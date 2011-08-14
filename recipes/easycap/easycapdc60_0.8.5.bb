DESCRIPTION = "Linux device driver for the EasyCAP Model DC60"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS_${PN} = "kernel (${KERNEL_VERSION})"
DEPENDS = "virtual/kernel"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/easycap_dc60.${PV}.tar.gz"
SRC_URI[md5sum] = "258fed1a5c60b163eba3520842282485"
SRC_URI[sha256sum] = "226e3f81cc832175899d963becc380322cf60593c00a1ad5b6a57b6377883b02"

SRC_URI += " file://Makefile.patch "

S = "${WORKDIR}/easycap_dc60.${PV}/src"

inherit module

do_install() {	
	install         -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/
  	install -m 0644 ${S}/easycap.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/

}

PACKAGES = "${PN}"

FILES_${PN} = "${base_libdir}/modules/"
FILES_${PN} += "${sysconfdir}/"

