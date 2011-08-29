DESCRIPTION = "The Concurrent Versioning System (cvs) client - Feature Version "
SECTION = "console/network"
PRIORITY = "optional"
DEPENDS = ""
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://download.savannah.gnu.org/releases/cvs/source/feature/${PV}/cvs-${PV}.tar.bz2 \
	  "

inherit autotools gettext

EXTRA_OECONF = "--with-krb4=no --with-gssapi=no"

SRC_URI[md5sum] = "956ab476ce276c2d19d583e227dbdbea"
SRC_URI[sha256sum] = "78853613b9a6873a30e1cc2417f738c330e75f887afdaf7b3d0800cb19ca515e"
