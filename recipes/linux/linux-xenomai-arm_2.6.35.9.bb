require recipes/linux/linux.inc

DESCRIPTION = "Linux kernel for for beagleboard with xenomai patch"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(beagleboard)"
DEFAULT_PREFERENCE_beagleboard = "10"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV = "2.6.35.9"

FILESPATHPKG_prepend = "linux-xenomai-2.6.35:"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
	   file://adeos-ipipe-2.6.35.9-arm-1.18-01.patch \
	   file://uvc_quirk_fix_bandwidth.patch \
	   file://patch-2.6.35.9-l9.patch \
	   file://i2c2_100.patch \
	   file://defconfig"

S = "${WORKDIR}/linux-${PV}"

SRC_URI[kernel.md5sum] = "18d339e9229560e73c4249dffdc3fd90"
SRC_URI[kernel.sha256sum] = "f6bd671a163078c7bbf2030cdcf618f3c8a2864c185efbdc72638e00e25abf06"

