THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}-${PV}"], d)}:"

#FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

PRINC = "2"

SRC_URI += " file://07-linux3-regen-fix.patch \
"

