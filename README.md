[EOLANG](https://www.eolang.org) objects for JSON parsing.

This is how to include it and create json-object

```
+alias org.eolang.fs.json

"test_file.json".parse > parser
```




This is how you list all text files in a directory recursively:

```
+alias org.eolang.io.stdout
+alias org.eolang.txt.sprintf
+alias org.eolang.fs.directory
each. > @
  select.
    walk.
      directory "/tmp"
      "**/*"
    *
      [f] (f.is-dir.not > @)
      [f] (/\.txt$/.matches f > @)
  [f]
    stdout > @
      sprintf "file: %s" f
```


