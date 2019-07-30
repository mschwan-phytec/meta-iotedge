DESCRIPTION = "Standard mode libiothsm implementation for Azure IoT Edge"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=0f7e3b1308cb5c00b372a6e78835732d"

SRC_URI += "gitsm://github.com/azure/iotedge.git;protocol=https"
SRCREV = "f5186c42ebb721893c5a497c789236803de42fb7"

S = "${WORKDIR}/git/edgelet/hsm-sys/azure-iot-hsm-c"

DEPENDS += "openssl10"
PROVIDES += "virtual/libiothsm"
RPROVIDES_${PN} += "virtual/libiothsm"

EXTRA_OECMAKE += " \
    -DBUILD_SHARED=On \
    -Duse_emulator=Off \
    -Duse_http=Off \
    -Duse_default_uuid=On \
    -DCMAKE_SYSTEM_VERSION=10 \
"

inherit cmake
