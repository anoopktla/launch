package com.km.adamos.launchpad.core.device.infrastructure.adapter;

import com.cumulocity.rest.representation.inventory.ManagedObjectRepresentation;
import com.cumulocity.sdk.client.Param;
import com.cumulocity.sdk.client.Platform;
import com.cumulocity.sdk.client.QueryParam;
import com.cumulocity.sdk.client.inventory.InventoryFilter;
import com.cumulocity.sdk.client.inventory.ManagedObjectCollection;
import com.km.adamos.launchpad.core.device.domain.interfaces.DeviceAdapter;
import com.km.adamos.launchpad.core.device.domain.model.Device;
import com.km.adamos.launchpad.core.device.domain.model.DevicePerformanceData;
import com.km.adamos.launchpad.core.device.domain.model.DeviceSettings;
import com.km.adamos.launchpad.core.device.domain.model.Measurement;
import com.km.adamos.launchpad.core.device.domain.model.enums.SupportedDevices;
import com.km.adamos.launchpad.core.device.domain.model.enums.SupportedMeasurements;
import com.km.adamos.launchpad.core.device.domain.model.enums.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class C8YDeviceAdapter implements DeviceAdapter {


  private static final String FRAGMENT_TYPE_C8Y_DEVICE = "c8y_IsDevice";
  private static final Logger LOGGER = LoggerFactory.getLogger(C8YDeviceAdapter.class);
  private Platform platform;

  public C8YDeviceAdapter(Platform platform) {
    this.platform = platform;
  }

  @Override
  public List<Device> loadDevices() {
    InventoryFilter filter = new InventoryFilter();
    filter.byFragmentType(FRAGMENT_TYPE_C8Y_DEVICE);
    ManagedObjectCollection managedObjectCollection = platform.getInventoryApi().getManagedObjectsByFilter(filter);

    managedObjectCollection.get().getPageStatistics();
    List<Device> neededDevices = getDeviceFromPlatformResponse(managedObjectCollection);
    LOGGER.debug("Returning {} supported devices from C8Y", neededDevices.size());
    return  neededDevices;
  }

  @Override
  public List<Device> loadDevicesPaginated(int page,int pageSize){
    return  null;
  }

  private List<Device> getDeviceFromPlatformResponse(ManagedObjectCollection managedObjects){
   Iterable<ManagedObjectRepresentation> iterable = () -> managedObjects.get().allPages().iterator();
   Stream targetStream  = StreamSupport.stream(iterable.spliterator(),false);

   List<ManagedObjectRepresentation> neededDevices = (List<ManagedObjectRepresentation>) targetStream.filter(managedObjectRepresentation ->
     SupportedDevices.isSupportedDevice(((ManagedObjectRepresentation)managedObjectRepresentation).getType())).collect(Collectors.toList());
   List<Device> devices = neededDevices.stream().map(managedObjectRepresentation -> {
     Measurement maxSpeed = getMeasurement(managedObjectRepresentation.getAttrs(), SupportedMeasurements.MAX_SPEED,Unit.RPM);
     Measurement maxOutput = getMeasurement( managedObjectRepresentation.getAttrs(),SupportedMeasurements.TARGET_SPEED,Unit.RPM);
     DevicePerformanceData devicePerformanceData = new DevicePerformanceData(maxSpeed,maxOutput);
     Measurement targetSpeed = getMeasurement( managedObjectRepresentation.getAttrs(),SupportedMeasurements.TARGET_SPEED,Unit.RPM);
     Measurement targetOutput = getMeasurement( managedObjectRepresentation.getAttrs(),SupportedMeasurements.TARGET_OUTPUT,Unit.RPM);
     Measurement minAvailability = getMeasurement( managedObjectRepresentation.getAttrs(),SupportedMeasurements.TARGET_OUTPUT,Unit.PERCENTAGE);
     DeviceSettings deviceSettings = new DeviceSettings(targetSpeed,targetOutput,minAvailability);
     Device device = new Device(managedObjectRepresentation.getId().getLong(),
       managedObjectRepresentation.getName(),managedObjectRepresentation.getType(),
       getPropertyName(managedObjectRepresentation.getAttrs(),"km_machineCode"),
       getPropertyName(managedObjectRepresentation.getAttrs(),"km_machineSerial"),devicePerformanceData,deviceSettings);
     return device;
   }).collect(Collectors.toList());
   return  devices;

  }
  private  String getPropertyName(Map<String,Object> attributes,String key){

    return attributes.get(key) != null ? attributes.get(key).toString() : "";
  }
  private Measurement getMeasurement(Map<String,Object> attributes,SupportedMeasurements measurement,Unit unit){
    String attributeValue  = attributes.get(measurement.getType()) != null ? attributes.get(measurement.getType()).toString() : "";
    return new Measurement(attributeValue,unit);
  }
}
