#!/bin/bash

project=training_tasks
repo=Task-9-07-09-19
remoteUrl="git@github.com:shivamy221/$repo.git"

echo $repoUrl
echo "$(pwd)"
cd ..
repoPath="$(pwd)"/$repo
echo $repoPath

#Get clone of repo that is to e added 
echo "cloning from remote repo URL:$remoteUrl"
git clone $remoteUrl

echo "changed directory to $project"
cd $project

#Merge repo into project
echo "adding remote to repo $repo from path:$repoPath"
git remote add $repo/master $repoPath

echo "fetching repo:$repo"
git fetch $repo

echo "merging repo:$repo to project:$project"
git merge $repo --allow-unrelated-histories

echo "removing remote repo:$repo"
git remote remove $repo


