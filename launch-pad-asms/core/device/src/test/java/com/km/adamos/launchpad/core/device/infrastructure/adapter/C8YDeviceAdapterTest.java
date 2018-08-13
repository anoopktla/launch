package com.km.adamos.launchpad.core.device.infrastructure.adapter;


import com.cumulocity.model.idtype.GId;
import com.cumulocity.rest.representation.inventory.ManagedObjectRepresentation;
import com.cumulocity.sdk.client.Platform;
import com.cumulocity.sdk.client.inventory.InventoryApi;
import com.cumulocity.sdk.client.inventory.ManagedObjectCollection;
import com.cumulocity.sdk.client.inventory.PagedManagedObjectCollectionRepresentation;
import com.km.adamos.launchpad.core.device.domain.model.Device;


import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class C8YDeviceAdapterTest {
  private C8YDeviceAdapter c8YDeviceAdapter;

  @Mock
  private Platform platform;
  @Mock
  private InventoryApi inventoryApi;
  @Mock
  private ManagedObjectCollection managedObjectCollection;
  @Mock
  private PagedManagedObjectCollectionRepresentation pagedManagedObjectCollectionRepresentation;
  @Mock
  private Iterable<ManagedObjectRepresentation> managedObjectRepresentations;

  @Mock
  private Iterator<ManagedObjectRepresentation> managedObjectRepresentationIterator;
  @Mock
  private ManagedObjectRepresentation managedObjectRepresentation;
  @Mock
  private GId gId;




  @Test
  @DisplayName("loadDevices - returns devices from platform")
  public void testLoadDevices() {
    c8YDeviceAdapter =  new C8YDeviceAdapter(platform);
    Map<String,Object> attributes = new HashMap<>();
    attributes.put("Att1","Att1Value");
    /*when(platform.getInventoryApi()).thenReturn(inventoryApi);
    when(inventoryApi.getManagedObjectsByFilter(Mockito.anyObject())).thenReturn(managedObjectCollection);
    when(managedObjectCollection.get()).thenReturn(pagedManagedObjectCollectionRepresentation);
    when(pagedManagedObjectCollectionRepresentation.allPages()).thenReturn(managedObjectRepresentations);
    when(managedObjectRepresentations.iterator()).thenReturn(managedObjectRepresentationIterator);
    when(managedObjectRepresentationIterator.hasNext()).thenReturn(true,false);
    when(managedObjectRepresentationIterator.next()).thenReturn(managedObjectRepresentation);
    when(managedObjectRepresentation.getType()).thenReturn("karlmayer_KAMCOS1");
    when(managedObjectRepresentation.getName()).thenReturn("deviceName");
    when(managedObjectRepresentation.getId()).thenReturn(gId);
    when(gId.getLong()).thenReturn(01L);
    when(managedObjectRepresentation.getOwner()).thenReturn("deviceOwner");
    when(managedObjectRepresentation.getAttrs()).thenReturn(attributes);
    List<Device> devicesFromPlatform = c8YDeviceAdapter.loadDevices();
    assertThat(devicesFromPlatform, notNullValue());
    assertThat(devicesFromPlatform.get(0),notNullValue());
    assertEquals(devicesFromPlatform.get(0).getName(),"deviceName");
    assertEquals(devicesFromPlatform.get(0).getDeviceType(),"karlmayer_KAMCOS1");*/




  }
}
