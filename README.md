<img src="https://www.yegor256.com/images/books/elegant-objects/cactus.svg" height="100px" />

[![EO principles respected here](https://www.elegantobjects.org/badge.svg)](https://www.elegantobjects.org)
[![DevOps By Rultor.com](http://www.rultor.com/b/objectionary/eo-hamcrest)](http://www.rultor.com/p/objectionary/eo-hamcrest)
[![We recommend IntelliJ IDEA](https://www.elegantobjects.org/intellij-idea.svg)](https://www.jetbrains.com/idea/)

[![Maven Central](https://img.shields.io/maven-central/v/org.eolang/eo-hamcrest.svg)](https://maven-badges.herokuapp.com/maven-central/org.eolang/eo-hamcrest)
[![mvn](https://github.com/objectionary/eo-hamcrest/actions/workflows/mvn.yml/badge.svg)](https://github.com/objectionary/eo-hamcrest/actions/workflows/mvn.yml)
[![codecov](https://codecov.io/gh/cqfn/eo/branch/master/graph/badge.svg)](https://codecov.io/gh/cqfn/eo)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/Graur/eo-tests/blob/master/LICENSE.txt)

[![Maintainability](https://api.codeclimate.com/v1/badges/b8b59692f3c8c973ac54/maintainability)](https://codeclimate.com/github/objectionary/eo-hamcrest/maintainability)
[![Hits-of-Code](https://hitsofcode.com/github/graur/eo-hamcrest)](https://hitsofcode.com/github/graur/eo-hamcrest/view)
![Code-Size](https://img.shields.io/github/languages/code-size/objectionary/eo-hamcrest)
![Lines of code](https://img.shields.io/tokei/lines/github/objectionary/eo-hamcrest)

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

## How to Contribute
Fork this repository, make changes, send us a [pull request](https://www.yegor256.com/2014/04/15/github-guidelines.html).
We will review your changes and apply them to the `master` branch shortly,
provided they don't violate our quality standards. To avoid frustration,
before sending us your pull request please run full Maven build:
```bash
$ mvn clean install -Pqulice
```

You will need Maven 3.3+ and Java 8+.