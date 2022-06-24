# jplantuml4r

[![R-CMD-check](https://github.com/terminological/jplantuml4r/workflows/R-CMD-check/badge.svg)](https://github.com/terminological/jplantuml4r/actions)


To generate the R code from the Java classes in this example library run: 

```BASH
cd ~/Git/jplantuml4r/src
mvn install
```

The newly generated R project can be pushed to github where it should trigger appropriate workflows if the organisation and repository names given above match.

```BASH
cd ~/Git/jplantuml4r
git init -b main
git add . 
git commit -m "initial commit"
gh repo create terminological/jplantuml4r --source=. --public
git push

```

Once the basic structure is setup more background on developing useful functionality in your package is available here:

https://github.com/terminological/r6-generator-docs

After this is done this development section does not need to be in your README.md for users, and can be taken out. 


This template readme should be updated to include documentation for the end users of your R-package with the aims and objectives, installation and usage guide for your users

`jplantuml4r` is based on a java library and must have a working version of `Java` and `rJava` installed prior to installation. The following commands can ensure that your `rJava` installation is working.


```R
install.packages("rJava")
rJava::.jinit()
rJava::J("java.lang.System")$getProperty("java.version")
```

To install `jplantuml4r` in R:

```R
library(devtools)
# you can install from the local copy:
load_all("~/Git/jplantuml4r")

# or from your github repository:
# install_github("terminological/jplantuml4r")
```

A basic usage scenario:


```R
# a basic smoke test
J = jplantuml4r::JavaApi$get()

# exploring the API using autocomplete in RStudio
# is a matter of typing J$<ctrl-space> 

tmp = J$BasicExample$new()
tmp$doHelloWorld()

# generated documentation will be available

?jplantuml4r-package
?jplantuml4r::BasicExample

```

The following links will take you to the R library documentation (e.g. pkgdown site) once this has been generated from the Java code, and assuming Github pages has been enabled for the repository.  

see the [full docs](https://terminological.github.io/jplantuml4r)

see the [jplantuml4r home page](https://terminological.github.io/jplantuml4r/docs/)


