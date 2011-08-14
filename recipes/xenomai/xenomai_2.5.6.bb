require xenomai.inc

SRC_URI = "http://download.gna.org/xenomai/stable/xenomai-${PV}.tar.bz2 \
	   file://Makefile-sudo.patch;apply=yes "

SRC_URI[md5sum] = "fbc1347de290d76c6eb1665e2510f545"
SRC_URI[sha256sum] = "54ccacff53fa1aa75462ae023b9a9ba789c4a7a291a084e818b541636fc5fd03"

EXTRA_OECONF += " --includedir=/usr/include/xenomai --enable-arm-mach=omap3 --enable-arm-eabi --enable-arm-tsc --disable-dox-doc --disable-dbx "

TARGET_CC_ARCH += "${LDFLAGS}"
