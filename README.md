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
  
# 'found' returns an array empty (if the item wasn't found)
# or with one element (if the item was found)
  
# How to get object from map by key
mp2.found "name" > res
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
+alias org.eolang.fs.json
+alias org.eolang.collections.map

# The first way is to wrap the map (here 'mp' has the type map)
json mp > x

# The second way is to parse the text
x.parse "there should be a json string" > x2
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

# 'found' returns an array empty (if the item wasn't found)
# or with one element (if the item was found).
# If the array isn't empty, the element in it is also a json
(x.found "books").at 0 > books

# 'with' operation puts the object in the field where we are now
x.with key some-json > new-x

stdout > @
  sprintf
    "In the %s %s I took a book called %s"
    ((((x.found "description").at 0).found "color").at 0).as-string
    ((x.found "essence").at 0).as-string
    (((books.at 0).found "title").at 0).as-string 
```

The creation and use of a new json object
```
# creating of empty json object
jsn.parse "{}" > x

with. > x2
  with.
    x
    "age"
    20
  "state"
  "good"
```

**x2** after the previous block of code
```
{
  "age": 20,
  "state": "good"
}
```
