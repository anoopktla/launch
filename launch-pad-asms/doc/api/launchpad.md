FORMAT: 1A
HOST: https://karlmayer.adamos-dev.com

# Launchpad API

## Authorization
Authorization is based on [Basic authentication](https://en.wikipedia.org/wiki/Basic_access_authentication)  
Each request requires the `Basic` Header to be present with `Base64` encoded username and password

In case not provided or wrong the api will respond with an unauthorized message

  ```http
    Authorization: Bearer vr5HmMkzlxKE70W1y4MibiJUusZwZC25NOVBEx3BD1
  ```

  ```json
  
    {
      "error": "security/Unauthorized",
      "info": "https://www.cumulocity.com/guides/reference-guide/#error_reporting",
      "message": "Invalid credentials! : Bad credentials"
    }
    
  ```

# Group Devices
Device List Resource

## Device List [/devices{?number,cursor,include}]

### Get devices [GET]
Get list of accessible devices

  + Parameters
    
    + number = 10 (optional, integer, `10`) ... The number of results returned for each page
    + cursor (optional, string, `MQ==`)  ... Cursor for pagination
    + include (optional, string, `[measurements]`) ... include latest measurements in response
    
  + Request
  
          Authorization: Basic {token}
          Accept: application/vnd.karlmayer.launchpad.v1.devices+json

  + Response 200 (application/vnd.karlmayer.launchpad.v1.devices+json)

          {
            "data": [{
              "type": "devices",
              "id": "1",
              "attributes": {
                "metaData": {
                   "code": "01",
                  "number": "120125",
                  "name": "WEFTTRONIC 2"
                },
                "performanceData": {
                  "maxSpeed": {
                    "data": 3200,
                    "unit": "rpm"
                  },
                  "maxOutput": {
                    "data": 40,
                    "unit": "mh"
                  }
                },
                "settings": {
                  "targetSpeed": {
                    "data": 2800,
                    "unit": "rpm"
                  },
                  "targetOutput": {
                    "data": 30,
                    "unit": "mh"
                  },
                  "minAvailability": {
                    "data": 80,
                    "unit": "percent"
                  }
                }
              },
              "relationships": {
                "currentMeasurement": {
                  "links": {
                    "related": "https://karlmayer.adamos-dev.com/devices/1/measurements"
                  },
                  "data": [
                    { "type": "measurements", "id": "1"},
                    { "type": "measurements", "id": "2"}
                  ]
                }
              },
              "links": {
                "self": "https://karlmayer.adamos-dev.com/devices/1"
              }
            }],
            "included": [
              {
                "type": "measurements",
                "id": "1",
                "attributes": {
                  "deviceId": "1",
                  "productionSpeed": {
                    "data": 2800,
                    "unit": "rpm"
                  },
                  "output": {
                    "data": 10,
                    "unit": "mh"
                  },
                  "availability": {
                    "data": 80,
                    "unit": "percent"
                  },
                  "performance": {
                    "data": 25,
                    "unit": "percent"
                  },
                  "timestamp":  "2018-07-25T15:06:46.506+02:00"
                },
                "links": {
                  "self": "https://karlmayer.adamos-dev.com/devices/1/measurements/1"
                }
              },
              {
                "type": "measurements",
                "id": "2",
                "attributes": {
                  "deviceId": "1",
                  "productionSpeed": {
                    "data": 3200,
                    "unit": "rpm"
                  },
                  "output": {
                    "data": 15,
                    "unit": "mh"
                  },
                  "availability": {
                    "data": 90,
                    "unit": "percent"
                  },
                  "performance": {
                    "data": 16,
                    "unit": "percent"
                  },
                  "timestamp": "2018-07-25T15:06:46.506+02:00"
                },
                "links": {
                  "self": "https://karlmayer.adamos-dev.com/devices/1/measurements/2"
                }
              }
            ],
            "links": {
              "self": "https://karlmayer.adamos-dev.com/devices/1?cursor=MT=="
            },
            "paging": {
              "cursors": {
                "after": "https://karlmayer.adamos-dev.com/devices/1?cursor=NA==",
                "before": "https://karlmayer.adamos-dev.com/devices/1?cursor=MQ==",
                "current": "https://karlmayer.adamos-dev.com/devices/1?cursor=MT=="
              }
            }
          }


  
  + Response 415 (application/vnd.karlmayer.error.v1+json)
    
          [
            {
              "code": "unsupportedMediaType",
              "http_code": "415",
              "message": "Requested media type is not supported"
            }
          ]


  
  + Response 500 (application/vnd.karlmayer.error.v1+json)
  
          [
            {
              "code": "error",
              "http_code": "500",
              "message": "Internal server error"
            }
          ]
    
## Device [/devices/{id}{?include}]
Device Resource
  
  + Parameters
    
    + id (required, string, `1`) ... Device identifier

### Get device [GET]
Get a device

  + Parameters

    + include (optional, string, `[measurements]`) ... include latest measurements in response
  
  + Request
  
    + Headers
    
            Authorization: Basic {token}
            Accept: application/vnd.karlmayer.launchpad.v1.device+json
      
  + Response 200 (application/vnd.karlmayer.launchpad.v1.device+json)
  
          {
            "data": {
              "type": "devices",
              "id": "1",
              "attributes": {
                "metaData": {
                   "code": "01",
                  "number": "120125",
                  "name": "WEFTTRONIC 2"
                },
                "performanceData": {
                  "maxSpeed": {
                    "data": 3200,
                    "unit": "rpm"
                  },
                  "maxOutput": {
                    "data": 40,
                    "unit": "mh"
                  }
                },
                "settings": {
                  "targetSpeed": {
                    "data": 2800,
                    "unit": "rpm"
                  },
                  "targetOutput": {
                    "data": 30,
                    "unit": "mh"
                  },
                  "minAvailability": {
                    "data": 80,
                    "unit": "percent"
                  }
                }
              },
              "relationships": {
                "currentMeasurement": {
                  "links": {
                    "related": "https://karlmayer.adamos-dev.com/devices/1/measurements"
                  },
                  "data": [
                    { "type": "measurements", "id": "1"},
                    { "type": "measurements", "id": "2"}
                  ]
                }
              },
              "links": {
                "self": "https://karlmayer.adamos-dev.com/devices/1"
              }
            },
            "included": [
              {
                "type": "measurements",
                "id": "1",
                "attributes": {
                  "deviceId": "1",
                  "productionSpeed": {
                    "data": 2800,
                    "unit": "rpm"
                  },
                  "output": {
                    "data": 10,
                    "unit": "mh"
                  },
                  "availability": {
                    "data": 80,
                    "unit": "percent"
                  },
                  "performance": {
                    "data": 25,
                    "unit": "percent"
                  },
                  "timestamp": "2018-07-25T15:06:46.506+02:00"
                },
                "links": {
                  "self": "https://karlmayer.adamos-dev.com/devices/1/measurements/1"
                }
              },
              {
                "type": "measurements",
                "id": "2",
                "attributes": {
                  "deviceId": "1",
                  "productionSpeed": {
                    "data": 3200,
                    "unit": "rpm"
                  },
                  "output": {
                    "data": 15,
                    "unit": "mh"
                  },
                  "availability": {
                    "data": 90,
                    "unit": "percent"
                  },
                  "performance": {
                    "data": 16,
                    "unit": "percent"
                  },
                  "timestamp": "2018-07-25T15:06:46.506+02:00"
                },
                "links": {
                  "self": "https://karlmayer.adamos-dev.com/devices/1/measurements/2"
                }
              }
            ]
          }



  
  + Response 404 (application/vnd.karlmayer.error.v1+json)
  
          [
            {
              "code": "notFound",
              "http_code": "404",
              "message": "Device with the given id does not exist"
            }
          ]
  
  + Response 415 (application/vnd.karlmayer.error.v1+json)
      
          [
            {
              "code": "unsupportedMediaType",
              "http_code": "415",
              "message": "Requested media type is not supported"
            }
          ]


  + Response 500 (application/vnd.karlmayer.error.v1+json)
    
          [
            {
              "code": "error",
              "http_code": "500",
              "message": "Internal server error"
            }
          ]
  
## Device Measurement List [/device/{id}/measurements{?cursor,number}]

  + Parameters
  
    + id (required, string, `1`) ... Device identifier
    
### Get device measurements [GET]
Get device measurements

  + Parameters
  
    + number = 10 (optional, integer, `10`) ... The number of results returned for each page
    + cursor (optional, string, `MQ==`)  ... Cursor for pagination
    
  + Request
  
    + Headers
    
            Authorization: Basic {token}
            Accept: application/application/vnd.karlmayer.launchpad.v1.measurements+json
    
  + Response 200 (application/application/vnd.karlmayer.launchpad.v1.measurements+json)
  
          {
            "data": [
              {
                "type": "measurements",
                "id": "1",
                "attributes": {
                  "deviceId": "1",
                  "productionSpeed": {
                    "data": 2800,
                    "unit": "rpm"
                  },
                  "output": {
                    "data": 10,
                    "unit": "mh"
                  },
                  "availability": {
                    "data": 80,
                    "unit": "percent"
                  },
                  "performance": {
                    "data": 25,
                    "unit": "percent"
                  },
                  "timestamp": "2018-07-25T15:06:46.506+02:00"
                },
                "links": {
                  "self": "https://karlmayer.adamos-dev.com/measurements/1"
                }
              },
              {
                "type": "measurements",
                "id": "2",
                "attributes": {
                  "deviceId": "1",
                  "productionSpeed": {
                    "data": 3200,
                    "unit": "rpm"
                  },
                  "output": {
                    "data": 15,
                    "unit": "mh"
                  },
                  "availability": {
                    "data": 90,
                    "unit": "percent"
                  },
                  "performance": {
                    "data": 16,
                    "unit": "percent"
                  },
                  "timestamp": "2018-07-25T15:06:46.506+02:00"
                },
                "links": {
                  "self": "https://karlmayer.adamos-dev.com/measurements/2"
                }
              }
            ],
            "paging": {
              "cursors": {
                "after": "https://karlmayer.adamos-dev.com/measurements?cursor=NA==",
                "before": "https://karlmayer.adamos-dev.com/measurements?cursor=MQ==",
                "current": "https://karlmayer.adamos-dev.com/measurements?cursor=MT=="
              }
            }
          }


  
  + Response 404 (application/vnd.karlmayer.error.v1+json)
    
          [
            {
              "code": "notFound",
              "http_code": "404",
              "message": "Device with the given id does not exist"
            }
          ]
    
  + Response 415 (application/vnd.karlmayer.error.v1+json)
      
          [
            {
              "code": "unsupportedMediaType",
              "http_code": "415",
              "message": "Requested media type is not supported"
            }
          ]
  
  
  + Response 500 (application/vnd.karlmayer.error.v1+json)
    
          [
            {
              "code": "error",
              "http_code": "500",
              "message": "Internal server error"
            }
          ]
  
# Group Measurements

## Measurement [/measurements/{id}]
Measurements Resource

  + Parameters
  
    + id (required, string, `1`) ... Measurement identifier

### Get measurement [GET]

  + Request
  
    + Headers
    
            Authorization: Basic {token}
            Accept: application/vnd.karlmayer.launchpad.v1.measurement+json
      
  + Response 200 (application/vnd.karlmayer.launchpad.v1.measurement+json)
  
          {
            "data": {
              "type": "measurements",
              "id": "1",
              "attributes": {
                "deviceId": "1",
                "productionSpeed": {
                  "data": 2800,
                  "unit": "rpm"
                },
                "output": {
                  "data": 10,
                  "unit": "mh"
                },
                "availability": {
                  "data": 80,
                  "unit": "percent"
                },
                "performance": {
                  "data": 25,
                  "unit": "percent"
                },
                "timestamp": "2018-07-25T15:06:46.506+02:00"
              },
              "links": {
                "self": "https://karlmayer.adamos-dev.com/measurements/1"
              }
            }
          }


  
  + Response 404 (application/vnd.karlmayer.error.v1+json)
      
          [
            {
              "code": "notFound",
              "http_code": "404",
              "message": "Measurement with the given id does not exist"
            }
          ]
  
  + Response 415 (application/vnd.karlmayer.error.v1+json)
      
          [
            {
              "code": "unsupportedMediaType",
              "http_code": "415",
              "message": "Requested media type is not supported"
            }
          ]
    
    
  + Response 500 (application/vnd.karlmayer.error.v1+json)
    
          [
            {
              "code": "error",
              "http_code": "500",
              "message": "Internal server error"
            }
          ]
    
    
