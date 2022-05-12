[EOLANG](https://www.eolang.org) objects for JSON parsing.

The main idea is that everything is a json

Before using json, let's create a map object
```
+alias org.eolang.collections.map

# It's how created a map
map > mp
```

How to get and put object to map
```
map > mp

# This is how to add object with key "abc"
mp.add "abc"

# Here we go to the branch "abc" and write the value 1 there
# Here we go to the branch "abc" and write the value 1 there
(mp.leaf "abc").write 1
```

This is how create json object
```
+alias org.eolang.io.stdout
+alias org.eolang.txt.sprintf
+alias org.eolang.fs.json
+alias org.eolang.collections.map

# The first way is to parse the text
json.parse "there should be a json string" > x

# The second way is to wrap the map
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
