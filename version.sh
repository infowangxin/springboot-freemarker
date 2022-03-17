#!/bin/bash
cat springboot-freemarker/src/main/resources/banner.txt
# 默认版本号
DEFAULT_VERSION=2022.0.1
# 接输入参数做为新版本号
VERSION=${1:-$DEFAULT_VERSION}
# 更新版本号
mvn versions:set -DgenerateBackupPoms=false -DnewVersion=$VERSION
