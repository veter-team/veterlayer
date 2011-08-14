DESCRIPTION = "Robot control program"
HOMEPAGE = "http://veter-project.blogspot.com/"
LICENSE = "GPLv2"
SECTION = "console"

PV = "0.1"
PR = "r0"
BB_GENERATE_MIRROR_TARBALLS = "0"
CVS_TARBALL_STASH=""

inherit cmake

DEPENDS = "libicee gstreamer slice2cppe-native xenomai"

#SRC_URI = "git:///tmp/veter;protocol=git;branch=master"

do_fetch () {
	cp -a /tmp/veter ${WORKDIR}/
}

S = "${WORKDIR}/veter"
