require recipes/linux/linux.inc

DESCRIPTION = "Linux kernel for for beagleboard with xenomai patch"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(beagleboard)"
DEFAULT_PREFERENCE_beagleboard = "11"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV = "2.6.38.8"

FILESPATHPKG_prepend = "linux-xenomai-2.6.38:"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
	   file://linux-xenomai-arm-2.6.38.8.patch \
	   file://defconfig"

S = "${WORKDIR}/linux-${PV}"

SRC_URI[kernel.md5sum] = "d27b85795c6bc56b5a38d7d31bf1d724"
SRC_URI[kernel.sha256sum] = "71bde3722edba81e5585c612ed8f113bb9846f54a7aea50915e069c9c5e2f99b"

