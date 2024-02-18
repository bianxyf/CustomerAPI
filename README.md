## Customer Processing Documentation

### CustomerDataProcessing Console App
This program is created to look into the specified directory
and process any customers provided in the file. This app will call 
CustomerAPI to save the Customer Details provided in the csv file. 

To avoid re-processing the same file, once it has been processed, the
file is moved to a 'processed' folder within the specified directory.

Suggested Improvements:
* Currently checking whole contents of a given directory (resources/unprocessed) 
* but this can be improved allowing this to be an input field - and the directory
* above can be overwritten.
* 
### CustomerAPI

This API is created to handle saving and retrieving 
Customer Details.    


### Save Customer Details   
##### Request
  `POST /saveCustomerDetail`

    curl -X POST -H "Content-Type: application/json" -d "{\"customerReference\" : \"12357\",\"firstName\" : \"JJ\",\"lastName\" : \"Dee\",\"addressLine1\" : \"27 Forest Road\",\"addressLine2\" : \"Stretford\",\"town\" : \"Greater Manchester\",\"county\" : \"Manchester\",\"country\" : \"United Kingdom\",\"postCode\" : \"M32 8TP\"}" http://localhost:8080/saveCustomerDetail    

##### Input Parameters

  | parameter    | type   |
  |--------------|--------|
  | customerRef  | Long   |
  | firstName    | String |
  | lastName     | String |
  | addressLine1 | String |
  | addressLine2 | String |
  | town         | String |
  | county       | String |
  | country      | String |
  | postCode     | String |

##### Response

    HTTP/1.1 200
    Content-Type: application/json
    Transfer-Encoding: chunked
    Date: Sun, 18 Feb 2024 21:27:00 GMT

    {"customerReference":"12357","firstName":"JJ","lastName":"Dee","addressLine1":"27 Forest Road","addressLine2":"Stretford","town":"Greater Manchester","county":"Manchester","country":"United Kingdom","postCode":"M32 8TP","id":3}

### Get Customer Details
##### Request
`GET /getCustomerDetail/{id}`   

    curl -i http://localhost:8080/getCustomerDetail/123

##### Response

    HTTP/1.1 200
    Content-Type: application/json
    Transfer-Encoding: chunked
    Date: Fri, 16 Feb 2024 20:37:52 GMT     

    {"customerReference":"123","firstName":"Bianca","lastName":"Findlay","addressLine1":"1 Home Road","addressLine2":"","town":"Manchester","county":"","country":"United Kingdom","postCode":"M22 5PR","id":1}