DESCRIPTION = "Robot control program"
HOMEPAGE = "http://veter-project.blogspot.com/"
LICENSE = "GPLv2"
SECTION = "console"

PR = "r0"
BB_GENERATE_MIRROR_TARBALLS = "0"
CVS_TARBALL_STASH=""

inherit cmake

DEPENDS = "libicee gstreamer slice2cppe-native"

SRC_URI = "git://gitorious.org/veter/veter.git;protocol=git;branch=master \
file://00-Makefile-vehicle-only.patch;apply=yes \
"

S = "${WORKDIR}/git"
