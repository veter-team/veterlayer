DESCRIPTION = "Linux device driver for the EasyCAP Model DC60"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS_${PN} = "kernel (${KERNEL_VERSION})"
DEPENDS = "virtual/kernel"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/easycap_dc60.${PV}.tar.gz"
SRC_URI[md5sum] = "2f4f8f931056ec4003b050d92e22d01f"
SRC_URI[sha256sum] = "d0e88acb32f55a567af461fb2de380c1addf6705d5c93afeef65cd2ca0d6364a"

SRC_URI += " file://Makefile.patch \
	     file://ioctlmess.patch \
"

S = "${WORKDIR}/easycap_dc60.${PV}/src"

inherit module

do_install() {	
	install         -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/
  	install -m 0644 ${S}/easycap.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/

}

PACKAGES = "${PN}"

FILES_${PN} = "${base_libdir}/modules/"
FILES_${PN} += "${sysconfdir}/"

