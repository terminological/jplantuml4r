# jplantuml4r

[![R-CMD-check](https://github.com/terminological/jplantuml4r/workflows/R-CMD-check/badge.svg)](https://github.com/terminological/jplantuml4r/actions)


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
# install_github("io.github.terminological/jplantuml4r", args = c("--no-multiarch"))
# N.B. the no-multiarch option is required for windows users with R versions prior to 4.2.0.
```

see the [full docs](https://io.github.terminological.github.io/jplantuml4r)

see the [jplantuml4r home page](https://io.github.terminological.github.io/jplantuml4r/docs/)


