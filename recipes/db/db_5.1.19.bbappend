# The configuration to enable c++ mappings and corresponding library
EXTRA_OECONF += " --enable-cxx --disable-rpath "
FILES_${PN} += "${libdir}/libdb_cxx-5*so*"
