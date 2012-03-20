require xenomai.inc

SRC_URI = "http://download.gna.org/xenomai/stable/xenomai-${PV}.tar.bz2 \
	   file://Makefile-sudo.patch;apply=yes "


EXTRA_OECONF += " --includedir=/usr/include/xenomai --enable-arm-mach=omap3 --enable-arm-eabi --disable-dox-doc --disable-dbx "

TARGET_CC_ARCH += "${LDFLAGS}"

FILES_${PN}-dbg += " \
	${datadir}/${PN}/regression/*/.debug \
"

SRC_URI[md5sum] = "360123b0616cc7499b4b3b9366711e08"
SRC_URI[sha256sum] = "84a6df0db6b45ca83340c38f4f325c51aa6b3744c59b32e493445fcf49f5f9eb"

