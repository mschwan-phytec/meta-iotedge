DEPENDS += "openssl virtual/libiothsm "
RDEPENDS_${PN} += "virtual/libiothsm "

export OPENSSL_DIR = "${STAGING_EXECPREFIXDIR}"
export LIBIOTHSM_NOBUILD="On"

do_install () {
    # HACK: Link to Git repository
    ln -s "${WORKDIR}/git" "${WORKDIR}/iotedge-${PV}"

    # Binaries
    install -d  "${D}${bindir}"
    install -m 755 "${WORKDIR}/iotedge-${PV}/edgelet/target/${CARGO_TARGET_SUBDIR}/iotedge" ${D}${bindir}/iotedge
}

