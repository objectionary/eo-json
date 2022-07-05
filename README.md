[EOLANG](https://www.eolang.org) objects for JSON parsing.

The main idea is that everything is a json

Before using json, let's create a map object
```
+alias org.eolang.collections.map

# It's how created a map
map * > mp
```

How to get and put object to map
```
map * > mp

# When you put the object using method 'with' you get new map with this new object.
# Each element you put is an array of two elements: (* key value)
# This is how to put objects
with. > mp2
  with.
    with.
      mp
      34
      9
    55
    "hello"
  "name" 
  "eugene"
  
# 'find' returns an array empty (if the item wasn't found)
# or with one element (if the item was found)
  
# How to get object from map by key
mp2.find "name" > res
if. > name
  res.is-empty
  "unnamed"
  res.get 0
```

How to remove object from map
```
mp2.without 55 > mp3
mp2.find 55 > res1 // here is a one-item array
mp3.find 55 > res2 // it's empty here
```

This is how to create json object
```
+alias org.eolang.io.stdout
+alias org.eolang.txt.sprintf
+alias org.eolang.fs.json
+alias org.eolang.collections.map

# The first way is to parse the text
json.parse "there should be a json string" > x

# The second way is to wrap the map (here 'mp' has the type map)
json mp > x
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

# 'leaf' takes one or more values, and deepens along the specified path
# if an object with this name did not exist, it creates an empty json object
x.leaf "books" > books

# 'write' operation puts the object in the field where we are now
(x.leaf "essence").write "bookcase"

stdout > @
  sprintf
    "In the %s %s I took a book called %s"
    (x.leaf "description" "color").as-string
    (x.leaf "essence").as-string
    ((books.get 0).leaf "title").as-string 
```

The creation and use of a new json object
```
# creating of empty json object
json.parse "{}" > x

(x.leaf "age").write 20
  
(x.leaf "state").write "good"
```

**x** after the previous block of code
```
{
  "age": 20,
  "state": "good"
}
```
