#!/bin/sh
set -eu

PROJECT_DIR=$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)
MAVEN_VERSION=3.9.16
ARCHIVE_NAME="apache-maven-$MAVEN_VERSION-bin.tar.gz"
MAVEN_USER_HOME=${MAVEN_USER_HOME:-"$HOME/.m2"}
DIST_ROOT="$MAVEN_USER_HOME/wrapper/dists/apache-maven-$MAVEN_VERSION"
MAVEN_HOME="$DIST_ROOT/apache-maven-$MAVEN_VERSION"

if [ ! -x "$MAVEN_HOME/bin/mvn" ]; then
    mkdir -p "$DIST_ROOT"
    ARCHIVE_PATH="$DIST_ROOT/$ARCHIVE_NAME"
    DISTRIBUTION_URL="https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/$MAVEN_VERSION/$ARCHIVE_NAME"
    echo "Downloading Apache Maven $MAVEN_VERSION..."
    if command -v curl >/dev/null 2>&1; then
        curl --fail --location --silent --show-error "$DISTRIBUTION_URL" --output "$ARCHIVE_PATH"
    elif command -v wget >/dev/null 2>&1; then
        wget --quiet "$DISTRIBUTION_URL" --output-document="$ARCHIVE_PATH"
    else
        echo "The Maven wrapper needs curl or wget to download Maven." >&2
        exit 1
    fi
    tar -xzf "$ARCHIVE_PATH" -C "$DIST_ROOT"
    rm -f "$ARCHIVE_PATH"
fi

cd "$PROJECT_DIR"
exec "$MAVEN_HOME/bin/mvn" "$@"
