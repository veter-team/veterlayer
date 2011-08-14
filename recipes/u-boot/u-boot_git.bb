require u-boot.inc
PR = "r78"

FILESPATHPKG =. "u-boot-git:"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git;tag=v2011.06"

PV = "2011.06"

S = "${WORKDIR}/git"

