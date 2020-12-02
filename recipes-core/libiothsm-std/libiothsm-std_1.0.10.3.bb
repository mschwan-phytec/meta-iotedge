DESCRIPTION = "Standard mode libiothsm implementation for Azure IoT Edge"
LICENSE = "MIT"

LIC_FILES_CHKSUM=" \
file://LICENSE;md5=b98fddd052bb2f5ddbcdbd417ffb26a8 \
"

#SRC_URI += "https://github.com/Azure/azure-iotedge/releases/download/${PV}/iotedge-${PV}.tar.gz"
#SRC_URI[md5sum]="e5b28b34b721a9353ff623374678edf9"
#SRC_URI[sha256sum]="6fbf23972d243624b280546cda4d47a336988fb6beedf0bc44cb29498663edff"
SRC_URI += "gitsm://github.com/Azure/iotedge;nobranch=1"
SRCREV = "95aa3cb67f16386be6c76e83feeb6538f6e040b9"

S = "${WORKDIR}/git/edgelet/hsm-sys/azure-iot-hsm-c"

DEPENDS += "openssl"
PROVIDES += "virtual/libiothsm"
RPROVIDES_${PN} += "virtual/libiothsm"

EXTRA_OECMAKE += "-DBUILD_SHARED=On -Duse_emulator=Off -Duse_http=Off -Duse_default_uuid=On -DCMAKE_SYSTEM_VERSION=10"
inherit cmake

