[EOLANG](https://www.eolang.org) objects for JSON parsing.

The main idea is that everything is a json (there is not a json-array)

This is how create json object
```
+alias org.eolang.io.stdout
+alias org.eolang.txt.sprintf
+alias org.eolang.fs.json
+alias org.eolang.collections.map

# The first way is to parse the text
json.parse "there should be a json string" > x

# The second way is to wrap the map
json.wrap map > x
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

# 'leaf' operation always returns json object
# if an object with this name did not exist, it creates an empty json object
x.leaf "books" > books

# 'put' operation puts the object in the field where we are now
(x.leaf "essence").put "bookcase"

stdout > @
  sprintf
    "In the %s %s I took a book called %s"
    ((x.leaf "description").leaf "color").as-string
    (x.leaf "essence").as-string
    (((x.leaf "books").leaf 0).leaf "title").as-string 
    
# we don't have a data type like json-array, so to access a specific element, you need to refer to his index
```

The creation and use of a new json object
```
# creating of empty json object
json.parse "{}" > x

(x.leaf "age").put 20
  
(x.leaf "state").put "good"
```

**x** after the previous block of code
```
{
  "age": 20,
  "state": "good"
}
```
