require u-boot.inc
PR = "r79"

FILESPATHPKG =. "u-boot-git:"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git;tag=v2011.06 \
	   file://bootdelay.patch \
	"

PV = "2011.06"

S = "${WORKDIR}/git"

