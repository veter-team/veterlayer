require recipes/u-boot/u-boot.inc

# SPL build
UBOOT_BINARY = "u-boot.bin"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.bin"
UBOOT_SYMLINK = "u-boot-${MACHINE}.bin"

PV = "2011.09"
PR = "r95"

# No patches for other machines yet
COMPATIBLE_MACHINE = "(beagleboard|pandaboard|hawkboard|am3517-evm|am37x-evm|omap3evm)"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git;tag=v2011.09 "

S = "${WORKDIR}/git"

RRECOMMENDS_${PN}_beagleboard = "u-boot-fw-utils"
