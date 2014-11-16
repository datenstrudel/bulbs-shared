#!/bin/bash
set -ev
BRANCH_TO_RELEASE="test/release"
if [ "${TRAVIS_BRANCH}" = "ci/releaseTrigger" ]; then
  git clone --depth=50 --branch=${BRANCH_TO_RELEASE} git://github.com/datenstrudel/bulbs-shared.git master
  cd master
  pwd | xargs echo "Operating in path: "
  openssl aes-256-cbc -d -a -pass pass:${GPG_ENCR_KEY} -in ci-scripts/pubring.gpg.encr -out ci-scripts/local.pubring.gpg
  openssl aes-256-cbc -d -a -pass pass:${GPG_ENCR_KEY} -in ci-scripts/secring.gpg.encr -out ci-scripts/local.secring.gpg
  gpg --import ci-scripts/local.pubring.gpg
  gpg --allow-secret-key-import --import ci-scripts/local.secring.gpg
  gpg --list-keys
  echo "Branch is "${TRAVIS_BRANCH}
  git config --global user.email "twx1@gmx.de"
  git config --global user.name "Travis CI Release"
  git config credential.helper "store --file=.git/credentials"
  echo "https://${TRAVIS_GITHUB_TK}:@github.com" > .git/credentials
  cat .git/HEAD|xargs echo "Head is: "
  echo "Starting Maven release... "
  PASSPHRASE_STRING="-Darguments=-Dgpg.passphrase="${GPG_PASSPHRASE}
  mvn -B release:clean release:prepare --settings ci-scripts/settings.xml
  mvn -B release:perform ${PASSPHRASE_STRING} --settings ci-scripts/settings.xml
fi
