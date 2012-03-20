DESCRIPTION = "The Internet Communications Engine"
LICENSE = "GPL"
PR = "r0"

BBCLASSEXTEND = "native"

DEPENDS += "db bzip2 mcpp expat openssl"

SRC_URI = "http://www.zeroc.com/download/Ice/3.4/Ice-${PV}.tar.gz;name=ice \
	file://20-kfreebsd.patch \
	file://20-missing-monotonic.patch \
	file://30-bashisms-cs-makefile.patch \
	file://10-build-qt-sql.patch \
	file://05-lightweight-cpp-make.patch \
	file://10-debug-flags.patch \
	file://10-java-policy.patch \
	file://10-install-pylibdir.patch \
	file://10-install-rblibdir.patch \
	file://10-install-clibindir.patch \
	file://archs.patch \
	file://libdb5.1.patch \
	file://ptrdiff_t-gcc-4.6.patch \
	file://cpp-make-rules.patch \
	file://make-cross.patch" 

SRC_URI[ice.md5sum] = "e97672eb4a63c6b8dd202d0773e19dc7"
SRC_URI[ice.sha256sum] = "dcf0484495b6df0849ec90a00e8204fe5fe1c0d3882bb438bf2c1d062f15c979"

S = "${WORKDIR}/Ice-${PV}"

PYTHON_MAJMIN = "2.6"

inherit autotools 

do_configure() {
	:
}

do_install () {
        oe_runmake prefix=${D}${prefix} install
}
NATIVE_INSTALL_WORKS = "1"

