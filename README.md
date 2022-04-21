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
    parser.as-string
```

test_file.json
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
"test_file.json".parse > parser

parser.put
  "essence"
  "bookcase"

stdout > @
  sprintf
    "In the %s %s I took a book called %s"
    (parser.get "description").get "color"
    parser.get "essence"
    ((parser.get "books").get 0).get "title"
```

Creating and saving data 
```
json.create > json_obj
json_obj.put 
  "age"
  "20"
json_obj.put
  "state"
  "good"
  
# save json to file "jfile.json"
json_obj.save "jfile.json"
```

