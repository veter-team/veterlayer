require u-boot.inc
PR = "r90"

FILESPATHPKG =. "u-boot-git:"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git;tag=v2011.12 \
	"

PV = "2011.12"

S = "${WORKDIR}/git"

