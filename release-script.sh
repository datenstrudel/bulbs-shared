#!/bin/bash
set -ev

if [ "${TRAVIS_BRANCH}" = "ci/releaseTrigger" ]; then
  git clone --depth=50 --branch=master git://github.com/datenstrudel/bulbs-shared.git master
  cd master
  openssl aes-256-cbc -pass pass:$GPG_ENCR_KEY -in pubring.gpg.encr -out local.pubring.gpg -d
  openssl aes-256-cbc -pass pass:$GPG_ENCR_KEY -in secring.gpg.encr -out local.secring.gpg -d
  gpg --import local.pubring.gpg
  gpg --allow-secret-key-import --import local.secring.gpg
  gpg --list-keys
  echo "Branch is "$TRAVIS_BRANCH
  git config --global user.email "twx1@gmx.de"
  git config --global user.name "Travis CI Release"
  git config credential.helper "store --file=.git/credentials"
  echo "https://${TRAVIS_GITHUB_TK}:@github.com" > .git/credentials
  cat .git/HEAD|xargs echo "Head is: "
  echo "Starting Maven release... "
  mvn -B release:clean release:prepare --settings settings.xml
  mvn release:perform --settings settings.xml
fi
