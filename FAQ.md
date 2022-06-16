# F.A.Q

#### How to convert a regular HTML file to thymeleaf HTML?
Add following `xmlns` to regular HTML.
```
<html lang="en" xmlns:th="http://www.thymeleaf.org">
```
#### How to link a file with thymeleaf?
```
th:href="@{<relative path to file from src/main/resources/static>}"

Example: 
<link th:href="@{/css/custom.css}" rel="stylesheet" media="screen"/>
```

#### How to replace file with thymeleaf?
We use thymeleaf `@{<relative path to file from src/main/resources/static>}` format to replace a css or js file in HTML.

Regular href 
```
<link href="main.css" rel="stylesheet">
```

Thymeleaf href   
```
<link href="main.css" rel="stylesheet" th:href="@{<relative path to css from src/main/resources/static>}">
```

Example
```
<link href="main.css" rel="stylesheet" th:href="@{/css/main-2.css}"/> 
//main.css is replaced by main-2.css

Similarly

<script src="main.js" th:src="@{/js/main-2.js}"></script>
//main.js is replaced by main-2.js

Similarly

<img src="main.jpeg" th:src="@{/images/main-2.jpeg}"/>
//main.jpeg is replaced by main-2.jpeg
```
**Note** We need both regular HTML attributes and thymeleaf attributes. Cause regular HTML attributes are used to render webpage in browser, whereas thymeleaf attributes are used to render templates by Spring MVC internally.
#### How to remove all contents with thymeleaf tag?
Use `th:remove="all"`on any HTML tag.

```
Example:
<style th:remove="all">
    .container{color:black}
    .div{bg-color: white}
</style>
```
#### How to externalize text from HTML file?
- Spring has default configuration for thymeleaf template with `messages.properties` file.  
- No need of extra configurations, just create messages.properties file under `src/main/resources` and you are good to go.
```
messages.properties
--------------------
index.title.name=index page
index.header.name=Thymeleaf demo
```
- Now we can refer them using `th:text="#{<property name from messages.properties>}"` symbol on thymeleaf.
```
<html>
    <title th:text="#{index.title.name}">Page title</title>
</html>

//Here "Page title" will be replaced by value rendered by "index.title.name".
```

#### How to use thymeleaf fragments?
Step1 **Create fragment:**   
Create regular html file under `src/main/resources/templates` and name it as `th:fragment`
```
src > main > resources > templates > fragments > footer.html
-------------------------------------------------------------
<html>
    <div class="container" th:fragment="footer">
        <p> You are in footer</p>
    </div>
</html>
```
Step2 **Refer fragment:** Use `th:replace="fragments/<html file name> :: <fragment name>`
```
src > main > resources > templates > index.html
-------------------------------------------------

<div class="container" th:replace="fragments/footer :: footer"></div>

Where
 - fragments/footer = footer.html under fragments folder.
 - :: footer = fragment name under footer.html (Note: A HTML file may contain multilpe fragments) 

```
