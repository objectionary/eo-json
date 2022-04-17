[EOLANG](https://www.eolang.org) objects for JSON parsing.

This is how to include and print the whole json

```
+alias org.eolang.io.stdout
+alias org.eolang.txt.sprintf
+alias org.eolang.fs.json

"test_file.json".parse > parser
stdout > @
  sprintf
    "Data:\n%s"
    parser.get
```

test_file.json
```
{
  "id": 1,
  "essence": "bookcase",
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
+alias org.eolang.io.stdout
+alias org.eolang.txt.sprintf
+alias org.eolang.fs.json

"test_file.json".parse > parser
stdout > @
  sprintf
    "In the %s %s I took a book called %s"
    (parser.get "description").get "color"
    parser.get "essence"
    ((parser.get "books").get 0).get "title"
```


