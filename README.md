[EOLANG](https://www.eolang.org) objects for JSON parsing.

This is how to include and print the whole json

```
+alias org.eolang.io.stdout
+alias org.eolang.txt.sprintf
+alias org.eolang.fs.json
+alias org.eolang.collections.map

# The first way is to parse the text
json.parse "there should be a json string" > x

# The second way is to wrap the map
json.wrap map > x

stdout > @
  sprintf
    "Data: \n%s"
    x.as-string
```

JSON string for the following examples (the name of the string is **data**)
```
{
  "id": 1,
  "books": [
    {
      "title": "Winnie the Pooh",
      "author": "Alexander Milne"
    },
    {
      "title": "Hamlet",
      "author": "William Shakespeare"
    }
  ],
  "description": {
    "color": "black",
    "material": "wood"
  }
}
```

Simple manipulations
```
json.parse data > x

# 'put' operation create new field (key, value) in json object
x.put
  "essence"
  "bookcase"

# every 'get' operation returns json object
# this piece of code writes json-array to a variable 'books'
x.get "books" > books

stdout > @
  sprintf
    "In the %s %s I took a book called %s"
    ((x.get "description").get "color").as-string
    (x.get "essence").as-string
    (((x.get "books").get 0).x "title").as-string 

```

The creation and use of a new json object
```
# creating of empty json object
json.parse "{}" > x

x.put 
  "age"
  20
x.put
  "state"
  "good"
```

'x' after the previous block of code
```
{
  "age": 20,
  "state": "good"
}
```
