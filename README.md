[EOLANG](https://www.eolang.org) objects for JSON parsing.

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

You are welcome to add more primitives to this lib.

Simple manipulations:

```
# Make a new object representing a file on disc
+alias org.eolang.fs.file
file > f
  "/tmp/foo.txt"
# Get its name:
stdout
  sprintf
    "File name is: %s"
    f
# Does it exist?
f.exists
# Is it a directory?
f.is-dir
# Touch it, to make sure it exists
f.touch
# Delete the file:
f.rm
# Rename/move it:
f.mv "/tmp/bar.txt"
# Get the size of it in bytes:
f.size > s
```

Reading:

```
# Read binary content into the "output," in 1024-bytes chunks;
# the "memory-as-output" is an abstract object with one free attribute,
# which is the memory where the bytes will be stored:
file "/tmp/foo.txt" > f
memory > m
copied
  f.as-input
  memory-as-output m
  1024
```

Writing:

```
# Write binary content, taking it from the "input",
# until input turns into a non-empty "bytes"; here the
# "mode" is the same as the mode in POSIX fopen();
# if the file is absent, it will be created:
file "/tmp/foo.txt" > f
copied
  bytes-as-input
    "你好, world!".as-bytes
  f.as-ouput "w+"
```

Smart object to help read content fast:

```
# This is the entire binary content of the file:
+alias org.eolang.fs.content
content f
```

Directories:

```
# Make an object representing a directory on disc:
+alias org.eolang.fs.directory
directory > d
  "/tmp"
# Make it if doesn't exist:
d.mkdir
# Delete it recursively:
d.rm-rf
# List all files recursively:
d.walk "**/*.txt"
```

Temporary files:

```
# This is a system directory for temporary files:
+alias org.eolang.fs.tmpdir
tmpdir > d
# Create an empty temporary file in a directory
d.tmpfile.@ > f
```

Name manipulations:

```
# Add path segment to existing file:
file "/tmp" > f
f.resolve "foo.txt"
# Get directory name:
+alias org.eolang.fs.dir-name
dir-name f
# Get base name (no directory, not extension):
+alias org.eolang.fs.base-name
base-name f
# Get extension:
+alias org.eolang.fs.ext-name
ext-name f
```

