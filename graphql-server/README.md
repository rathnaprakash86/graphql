# GrapQL Notes  

### **What is GraphQL** 

* GraphQL is a technology for client-server data exchange 
    * Client wants to access data on a server across a network 
* It has two building blocks 
    * Statically typed API or GraphQL Scheme 
    * Query Language 
* An alternative for Rest(ish*) API 
* Best fit for Single Page Apps and native clients 
* It prevents over-fetching and under-fetching of data 
* It sits on the API layer behind HTTP before the data-fetching layer 

<img src="./graphQLLocation.png"  width="400" height="300">

### GraphQL Scheme 
* Describe API 
* Defined on the Server 
* Based on simple static types system 
* SDL(Scheme Definition Language) is used to describe a Schema 

### GraphQL Query Language 
* Custom Query Language 
* Clients define the Query based on their needs 
* Every field needs to be requested explicitly 


### GraphQL type system
* Object types
* Interfaces
* Unions
* Enumerations
* Fields
* Lists
* Scalars
    * String
    * Float
    * Int
    * Boolean 
    * ID 
    * Custom Scalars e.g Date 

### GraphQL Operartions 
* Queries 
    * To read data 
       ```yaml
        query {
            search (q : "name"){
                title 
                author
            }
        }
* Mutations 
    * To write data 
       ```yaml
        mutation {
            create (title: "book"){
               id 
            }
        }
* Subscriptions 
    * Listen for data
       ```yaml
        subscription {
            onCreate {
               id 
               title 
            }
        }    

### Think in GrapQL Java 
* Start designing by putting the Scheme first 
* Define the schema in SDL 
* Schema is made out of types with fields 
* Fundamental Rule is every field has "DataFetcher" associated with 
    * DataFetecher fetches data for one field 
    * When no DataFetcher is provided, it uses the default DataFetcher (PropertyDataFetcher)
    * When the Pojo matches with Scheme, PropertyDataFetcher is enough no need to provide a custom DataFetcher

### DataFetcher  
<img src="./Sample_Scheme_DataFetcher.png"  width="600" height="300">

### DataFetcher Sequence 
 * Note :2a,2b,2c are parallel calls <Br>
<img src="./RequestExecution.png"  width="500" height="300">


### SpringGraphQL Layout 
<img src="./SpringGraphQL.png"  width="550" height="300">

### Spring Security and Context Propagation  
* Spring MVC
    * ThreadLocal context Propagation from Servlet container thread 
    * Need to register ThreadLocalAccessor 
    * Built-in accessor for Spring Security Context propagated 

* Spring WebFlux 
    * Reactor Context propagation from web layer 
    * Spring security context is propagated 

 <img src="./GraphQLSecurity.png"  width="550" height="300">
