#!/bin/bash

# Manual intervention is needed at end of execution of script since a commit
# message is need after merging which opens test editor and control is lost from script.

project=training_tasks
repo=Automation-Testing-Assignment
remoteUrl="git@github.com:shivamy221/$repo.git"


echo "Current directory:$(pwd)"

cd ..
repoPath="$(pwd)"/$repo
echo "changed directory to :$repoPath"

#Get clone of repo that is to e added 
echo "cloning from remote repo URL:$remoteUrl"
git clone $remoteUrl

echo "changed directory to $project"
cd $project

#Merge repo into project
echo "adding remote to repo $repo from path:$repoPath"
git remote add $repo $repoPath

echo "fetching repo:$repo"
git fetch $repo

echo "merging repo:$repo to project:$project"
git merge $repo/master --allow-unrelated-histories

echo "removing remote repo:$repo"
git remote remove $repo


