#!/bin/bash
set -ev

if [ ${TRAVIS_BRANCH}="ci/releaseConfig" ]; then
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
