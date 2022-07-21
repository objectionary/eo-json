[EOLANG](https://www.eolang.org) objects for JSON parsing.

The main idea is that everything is a json

This is how to create json object
```
+alias org.eolang.fs.json

# The first way is to call the json method 'of-...'
# It creates empty object/array or wrapped int/string
json.of-object > x1
json.of-array > x2
json.of-int 42 > x3
json.of-string "some string" > x4

# The second way is to parse the json text
json.parse "{age: 21, name: \"John\"}" > x5
```

JSON string for the following examples (the name of the string is **data**)
```
{
  "id": 1,
  "essence": "shelf",
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

The creation a new json object
```
# creating of empty json object
json.object > x

# example of creating a filled json
with. > x2
  with.
    with.
      json.of-object
      "name"
      json.of-string "shelf"
    "color"
    json.of-string "black wood"
  "books"
  with.
    with.
      json.of-array
      with.
        with.
          json.of-object
          "name"
          json.of-string "War and Peace"
        "age"
        json.of-int 1869
    with.
      with.
        json.of-object
        "name"
        json.of-string "Harry Potter"
      "age"
      json.of-int 1997
```

**x2** after the previous block of code
```
{
  books: [
    {name: "War and Peace", age: 1869},
    {name: "Harry Potter", age: 1997} 
  ],
  name: "shelf",
  color: "black wood" 
}
```
