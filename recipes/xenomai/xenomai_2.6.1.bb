require xenomai.inc

LIC_FILES_CHKSUM = "file://include/COPYING;md5=60faa041c8d4a75ab87e115a9469d94d"

SRC_URI = "http://download.gna.org/xenomai/stable/xenomai-${PV}.tar.bz2 \
	   file://Makefile-sudo.patch;apply=yes "


EXTRA_OECONF += " --includedir=/usr/include/xenomai --enable-arm-mach=omap3 --enable-arm-eabi --disable-dox-doc --disable-dbx "

TARGET_CC_ARCH += "${LDFLAGS}"

FILES_${PN}-dbg += " \
	${bindir}/regression/*/.debug \
"

FILES_${PN} += "/dev/*"
FILES_${PN} += "/usr/lib/posix.wrappers"

SRC_URI[md5sum] = "c6b067de392b1441da6528f1e503bf0a"
SRC_URI[sha256sum] = "0433153cb4a017ef275fa7fdb01ff389e290fd2c4013491b776d893139311f29"

