### Coding Exercise

 
 Problem : Consider a grocery store where items have prices per unit but also volume prices. For example, doughnuts may be $1.25 each or 3 for $3 dollars.
 Implement a point-of-sale scanning API that accepts an arbitrary ordering of products (similar to what would happen when you are actually at a checkout line) then returns the correct total price for an entire shopping cart based on the per unit prices or the volume prices as applicable.
 
 For the purposes of this exercise, assume the following products exist in the system (no need to provide an API to add new products, you can hardcode this data):
 
 ```
 Product Code Price
 
 ------------ -----
 
 A $1.25 each or 3 for $3.00
 
 B $4.25
 
 C $1.00 or $5 for a six pack
 
 D $0.75
 ```
 Your REST API should support the following operations:
 
 Scan a product. This scans a single Product Code
 Calculate total. This returns the total price for everything that has been scanned, taking into account the price rules defined above.
 For this sample, you do not have to worry about keeping track of different carts/sessions. Just assume one long running checkout process.
 
 Here are the minimal inputs you should use for your test cases. Please write tests for these inputs and make sure they are passing.
 Scan these items in this order: ABCDABA; Verify the total price is $13.25.
 Scan these items in this order: CCCCCCC; Verify the total price is $6.00.
 Scan these items in this order: ABCD; Verify the total price is $7.25.
 
 
 
 ## Running Application
 `` $ mvn spring-boot:run ``
 
 ### Sample Request
 ``$ curl -i http://localhost:8080/api/v1/shoppingcart/AAA ``
 
 ### Sample Response
 
 ```HTTP/1.1 200 
 Content-Type: application/json;charset=UTF-8 
 Transfer-Encoding: chunked 
 Date: Mon, 30 Jul 2018 16:41:06 GMT 
   
 {"plist":[{"pCode":"A","pPrice":1.25},{"pCode":"A","pPrice":1.25},{"pCode":"A","pPrice":1.25}],"totalPrice":"$3.00"}
   ```
### Testing Scenario 1
 ``$ curl -i http://localhost:8080/api/v1/shoppingcart/ABCDABA ``
 
```
HTTP/1.1 200 
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Mon, 30 Jul 2018 16:44:50 GMT

{"plist":[{"pCode":"A","pPrice":1.25},{"pCode":"B","pPrice":4.25},{"pCode":"C","pPrice":1.0},{"pCode":"D","pPrice":0.75},{"pCode":"A","pPrice":1.25},{"pCode":"B","pPrice":4.25},{"pCode":"A","pPrice":1.25}],"totalPrice":"$13.25"}
```  

### Testing Scenario 2
 ``$ curl -i http://localhost:8080/api/v1/shoppingcart/CCCCCCC ``
 
```
HTTP/1.1 200 
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Mon, 30 Jul 2018 16:46:12 GMT

{"plist":[{"pCode":"C","pPrice":1.0},{"pCode":"C","pPrice":1.0},{"pCode":"C","pPrice":1.0},{"pCode":"C","pPrice":1.0},{"pCode":"C","pPrice":1.0},{"pCode":"C","pPrice":1.0},{"pCode":"C","pPrice":1.0}],"totalPrice":"$6.00"}
```  


### Testing Scenario 3
 ``$ curl -i http://localhost:8080/api/v1/shoppingcart/ABCD ``
 
```
HTTP/1.1 200 
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Mon, 30 Jul 2018 16:46:30 GMT

{"plist":[{"pCode":"A","pPrice":1.25},{"pCode":"B","pPrice":4.25},{"pCode":"C","pPrice":1.0},{"pCode":"D","pPrice":0.75}],"totalPrice":"$7.25"}
```  
