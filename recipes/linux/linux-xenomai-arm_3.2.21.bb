require recipes-kernel/linux/linux.inc

DESCRIPTION = "Linux kernel for for beagleboard with xenomai patch"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(beagleboard)"
DEFAULT_PREFERENCE_beagleboard = "11"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV = "3.2.21"

FILESPATHPKG_prepend = "linux-xenomai-3.2.21:"


SRC_URI = "http://www.kernel.org/pub/linux/kernel/v3.x/linux-${PV}.tar.gz;name=kernel \
	   file://linux-3.2.21-xenomai-2.6.1.patch \
	   file://defconfig"

S = "${WORKDIR}/linux-${PV}"

SRC_URI[kernel.md5sum] = "08cd3a1d5747b722bf9cf9894de0d652"
SRC_URI[kernel.sha256sum] = "b25335170eeb8657ae866f77cc33dca361b692284323a75c165f7e892bbf9429"

