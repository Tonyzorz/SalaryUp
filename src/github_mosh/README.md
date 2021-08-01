# The ultimate git course by Mosh 

Github notes


01 Getting Started (15m) =========================================================

	3. What is git 
		Version control system 
		records in repository - can see history of who did what 
		Tracks history and work together 
		
		two types of version control system 
		
			centralized - all people work on one repository 
				ex. subversion (svn), microsoft team foundation server 
				
			Problem with centralized version control system is single point of failure**
			If the server goes offline, we cannot create snapshots,  
			
			Distributed - all people have their own repository locally, if server goes offline,
			we can work on repository directly with each others 
				ex. git, mercurial 
			
	4. Using git 
		
		command line 
		code editors & IDEs
		Graphical user interfaces 
			ex. gitkraken and sourcetree 
			
		gui tools have limitations 
		gui tools are not always available 
			
	5. installing git 

		check git version 
			git --verison 
			
		BASH = Born again Shell 
		
	6. configuring git 
		
		settings - name, email, default editor, line ending 
		
		System 
			all users 
			
		Global 
			all repositories of the current user 
			
		local 
			the current repository 
			
		git config --global user.name "Yoon Taewon"	
		git config --global user.email "tonyzorz@naver.com"	
		git config --global core.editor "code --wait"	
		git config --global -e 	
			
		end of line 
			windows - abc \r\n
				\r = carraige return 
				\n = line feed
				
			macOS / Linus - abc\n 
				\n = line feed 
				
			core.autocrlf 
			
				true = remove cr(\r) when updating repository 
					   add cr(\r) when checking out from repository 
						ex. windows users 
						
				input = just remove cr when updating if cr exists 
						but dont add cr when checking out 
						ex. macOS / linux users 
				
			git config --global core.autocrlf true 	
				
	7. getting help 
		
		git-scm.com/docs 
		git config --help 
	
	8. cheat sheet 
	
02 Creating Snapshots (60m) ======================================================

	1. introduction 
		
		workflows 
		watch every video even though you think you know it, because there are commmon misconceptions 
		
	2. initializing a repository 
		
		- initializes git repository in a directory 
			git init
		
		- git bash에서 간편하게 alias 추가하기 
			/etc/profile 수정 
			.bashrc 파일 생성 (bash shell 실행할때 처음에 실행되는 파일) 
			
		all git records are stored in directory .git 
		
		- when removing .git, every records disappears 
			rm -rf .git 
			
	3. git workflow 
		
		commit is like taking a snapshot of a project and storing into a repository 
		git contains middle area called staging area 
		
		staging area is like an index 
			can make multiple commits and review what is stored in the staging area 
			and then if all seems to be fine, take a snapshot and commit inside a repository 
		
		- add files to staging area 
			git add file1 file2 
			
		- take snapshot, commit to repository 
			git commit -m "initial commit."
			
		after commiting, files are still stored inside the staging area 
		in sourcetree, previous commited files that are inside staging area is not 
		displayed, only changes + differences with staging area is displayed.
	
		local file2 removed 
		- but file2 is still inside staging area 
			git add file2 
			
		each commit has 
			- unique id 
			- message 
			- date/time 
			- author 
			- complete snapshot 
			
		even though all commits are stored, git is very resourceful
			- compresses the content 
			- doesn't store duplicate content 
		
	4. staging files 
		
		echo hello > file1.txt 
		echo hello2 > file2.txt
		
		- see status of directory 
			git status 
		
		git add *.txt 
		git add . 
		
		git world >> file1.txt

		git add file1.txt 

	5. committing changes 
		
		posh-git for better cli view 
		https://choiseokwon.tistory.com/215
		
		- commit with comment 
			git commit -m "Initial commit."
			
		- commit without comment, opens a code editor allowing for multiple line of comments 
			git commit 

	6. committing best practices 
		
	7. skipping the staging area 
	
		echo test >> file1.txt 
		
		- skips staging, commits right away but not recommended 
			git commit -am "Fixed the bug that prevented the user from signing out"

	8. removing files 
		
		rm file2.txt 
		
		- view files in staging areas 
			git ls-files 
		
		git add file2.txt 

		git ls-files 
		
		**But more simple way is use : 
			git rm file2.txt 
			
			it removes files from working directory and well as in staging area 
		
	9. renaming or moving files 
	
		mv file1.txt main.js 
		git status
		git add file1.txt main.js 
		
		instead of using mv USE git mv 
		
	10. ignoring files 

		mkdir logs 
		echo hello > logs/dev.log 
		git status 
		
		echo logs/ > .gitignore
		
		code .gitignore

		git status 
		
		**when adding files/directories/patterns to .gitignore, it will ignore it from staging 
		But if it has been already commited and then added to .gitignore, it will not ignore.
		To fix this, you must remove the added file/directories from the staging area 
		before/after adding it to .gitignore 
		
		mkdir bin 
		echo helloworld > bin/app.bin
		
		git commit -m "added bin"
		
		echo bin/ >> .gitignore 
		
		echo helloworld2 >> bin/app.bin
		git status 
		
		git ls-files
		git rm -h 
		
		- just remove from staging area 
			git rm --cached bin/app.bin 

		git rm --cached -r bin/ 
		git ls-files 
		git status

	11. short status 
	
		echo sky >> file1.js 
		echo sky > file2.js 
		
		to make wording git status to short version : 
			git status -s 
		
		$ git status -s
			 M file1.js
			?? file2.js
			
			first column = staging area 
			second column = working directory 
			
		git add file1.js 
		
		$ git status -s
			M  file1.js
			?? file2.js
		
		echo ocean >> file1.js 
		$ git status -s
		MM file1.js
		?? file2.js

		git add file1.js
		git add file2.js 
		git status -s 
	
	12. viewing staged and unstagec changes 
		
		view difference between staging area and repository 
			git diff --staged 
		
		view difference between working directory and staging area 
			git diff 
			
		but viewing difference with cli is not very visually present and friendly,
		using a gui for more clear and visual representation is recommended 
		
	13. visual diff tools 
		
		kdiff3 
		p4merge 
		winmerge (only for windows)
		vscode 
		
		git config --global diff.tool vscode 
		git config --global difftool.vscode.cmd "code --wait --diff $LOCAL $REMOTE"
		
		to view config settings in default editor 
			git config --global -e 
		
	14. viewing history 
		
		to view history 
			git log 
			
		master = trunk = main branch 
		HEAD = what branch we are currently working on 
		
		to view history in one line 
			git log --oneline 
			
		to view history in one line and first commmit on top 
			git log --oneline --reverse 
		
	15. viewing a commit 
		
		git log --oneline 
		
			fff2c95 (HEAD -> master) removed and added gitignore
			2a32e80 Included bin/ in gitignore
			882b011 added bin
			7e138f9 Added gitignore
			acd5da5 Refactor code.
			0bc75f6 Removed unused Code.
			e51832c FIXED A BUG
			5551763 Initial commit

		git show 2a32e80
			same as 
		git show HEAD~1
		
		shows commit one previous from head, of .gitignore file information 
			git show HEAD~1:.gitignore 
		
		git ls-tree HEAD~1
		
	16. unstaging files 	
		
		to unstage a file 
			git restore --staged file1.js 
			
		what does git restore do? it takes the version from repostitory and applies it to 
		working directory 
		
	17. discarding local changes 

		git restore .  = removes all local changes, so it has staged file versions
		git restore file1.js 
		
		cat file1.js 
			helloworld
			world
			test
			sky
			ocean
		git restore . 
		cat file1.js 
			hello
			world
			test
		
		git clean -fd = removes even files that only exists in local repostitory. 		
		
	18. restoring a file to an earlier version 
		
		git rm file1.js 
		git status -s 
		git commit -m "Delete file1.js"
		
		want to restore removed file 
		git restore --source=HEAD~1  file1.js
		
	19. creating snapshots with vscode 
	
	20. creating snapshots with gitkraken 
	
	
		Example : 
			git ls-tree HEAD : to view files of the commit 
			
			git restore --staged file1.txt : to unstage the file 
			git rm --cached file1.txt : removes all previous version from stage 
			

		
03 Browsing History (44m) ========================================================

	1. introduction 
	2. getting a repository 
	3. viewing the history 
		
		view history oneline 
			git log --oneline 
		
		to view with changed files 
			git log --oneline --stat
		
		to view additional info of changed files 
			git log --oneline --patch 	
			
	4. filtering the history 
		
		see last 3 commits 
			git log --oneline -3 
		
		see by author 
			git log --oneline --author="Mosh"
		
		see by date 
			git log --oneline --after="2020-08-17"
						yesterday, one week ago
					
		see by search option 
			git log --oneline --grep="GUI"
			
			*it is case sensitive 
		
		see all history with OBJECTIVES and view file changes 
			git log --oneline -S"OBJECTIVES" --patch
			
		see from to from particular range 
			git log --oneline fb0d1..edb359
			
		see which commits have changes to certain file 
			git log --oneline toc.txt 
			
			if git complains and says file name is ambiguous use :
			git log --oneline -- toc.txt
			
			view changes with table of content files  
			
			git log --oneline --patch -- toc.txt
			
	5. formatting the log output 
	
		git log --pretty=format:"hello %an"
	
		git log --pretty=format:"%Cgreen%an committed %H on %cd"
		git log --pretty=format:"%Cgreen%an%Creset committed %H on %cd"
			
		%an = author name 
		%Cgreen = color 
		%Creset = reset to original color 
		%H = id in full length 
		%h = id in abbrviated 
		%cd = commit date 
		
	6. aliases 
	
		git config --global alias.lg "log --pretty=format:'%an committed %h'"
		git config --global -e 
		
		git config --global alias.unstage "restore --staged ."
		
	7. viewing a commit 
	
		git show HEAD~2
			or 
		git show 555b
		
		git show HEAD~2:sections/creating-snapshots/staging-changes.txt 
		
		to see which files have been commited 
			git show HEAD~2 --name-only 
		
		to see which files have been commited with status 
			git show HEAD~2 --name-status 
		
		
	8. viewing the changes across commits
	
		to see what has been changed past last 3 commits;
			git diff HEAD~2 HEAD 
			
		to see what has been changed past last 3 commmits + which files 
			git diff HEAD~2 HEAD audience.txt 
		
		only names 
			git diff HEAD~2 HEAD --name-only 
			
		with status 
			git diff HEAD~2 HEAD --name-status 
			
		
		
	9. checking out a commit 
	
		git log --oneline 
		
		a642e12 (HEAD -> master) Add header to all pages.
		50db987 Include the first section in TOC.
		555b62e Include the note about committing after staging the changes.
		91f7d40 Explain various ways to stage changes.
		edb3594 First draft of staging changes.
		24e86ee Add command line and GUI tools to the objectives.
		36cd6db Include the command prompt in code sample.
		9b6ebfd Add a header to the page about initializing a repo.
		fa1b75e Include the warning about removing .git directory.
		dad47ed Write the first draft of initializing a repo.
		fb0d184 Define the audience.
		1ebb7a7 Define the objectives.
		ca49180 Initial commit.

		checkout to 4th commit 
		
			git checkout dad47ed
			
		each commits points to the previous commit 
		
		default branch is master, which is main branch, some people call it trunk 
		HEAD points to current branch 
		
		WHEN a HEAD is not with MASTER, it is called detached HEAD 
		A commit should be not performed a a detached HEAD state, BECAUSE once commited 
		and HEAD is attached to MASTER, it has no pointers pointing towards detached HEAD commit,
		causing it for a dead commit. 
		
		to view all log history while in detached HEAD 
			git log --oneline --all 
		
		git checkout a462 AND git checkout master IS DIFFERENT 
		
		$ git checkout a642
		a642e12 (HEAD, master) Add header to all pages.
		
		$ git checkout master
		a642e12 (HEAD -> master) Add header to all pages.
	
		

	10. finding bugs using bisect 
	
		git bisect start 
		
		git bisect bad 
		git bisect good ca49180 
		
		git log --oneline --all 
		
		git bisect good 
		
		and keeps checking if it is a good or bad commit 
		once finished git will tell who commit and what changes were made 
		
		and with bad commit results, 
		type below to reset everything : 
		git bisect reset 
		
		
	11. finding contributors using shortlog
		
		view history by contributors 
			git shortlog

		git shortlog -h = to view help 
		git shortlog -n -s = numbered + show only commit count 
		
		for date range search 
			git shortlog -n -s --before="" --after=""
		
	12. viewing the history of a file 
	
		git log --oneline toc.txt 
		git log --oneline --stat toc.txt 
		git log --oneline --patch toc.txt 
		
	13. restoring a deleting file 
	
		git rm toc.txt
		git commit -m "Removed toc.txt"
		git log --oneline 
		git log --oneline -- toc.txt 
		git checkout a462(parent commit) toc.txt 
		git status -s 
		git commit -m "Restored toc.txt"
		
		
	14. finding the author of line using blame 
	
		git blame audience.txt 
		
		git blame -e audience.txt 
		
		to view lateset 3 
			git blame -e -L 1,3 audience.txt 
			
	15. tagging 
	
		git tag v1.0 a642
		
		git checkout v1.0 
		
		view all tags 
			git tag 
		
		a light weight tag, a pointer to commit 
		
		annotated tag, can assosiate tags with message 
			git tag -a v1.1 -m "My version 1.1"
		
		to view message 
			git tag -n 
		
			messages displayed is commit message for regular tag
			annotated message is displayed for annotated tag 
			
		git tag -d v1.1 
		
	16. browsing history using vscode 
	17. browsing the history using gitkraken 
	
04 Branching (76m) ===============================================================

	1. introduction 
	2. what are branches 
		
		branch allows for isloatation workspace from master branch 
		
		keep main master branch as stable as possible 
		
		centralized vs distibuted 
		centralized -	subversion branching copys all files from master branch 
			which can be very slow 
		
		distributed is super fast and efficient because it locates pointer to the 
			branching point 
		
		
	3. getting a repository 
	4. working with branches 

		create branch 
			git branch bugfix 
		
		see all branch 
			git branch 
				$ git branch
				  bugfix
				* master
				
				asterisk = current working branch 
		
		switching branches 
			git switch bugfix 
			
		rename branch 
			git branch -m bugfix bugfix/signup-form 
			
		remove branch 
			git branch -d bugfix/signup-form 
			

	5. comparing branches 
	
		compare branches 
			git log master..bugfix/signup-form 
			
		git diff master..bugfix/signup-form 
		git diff bugfix/signup-form 
		git diff --name-status bugfix/signup-form 
		git diff --name-only bugfix/signup-form 
		
		
	6. stashing 
		
		git does not allow switching branches if there are data that can be lost.
		
		This can be saved at a place called stash by : 
			git stash push -m "New tax rules"
			
		echo hello > newfile.txt 
		git status -s 
		git stash push -a -m "My new stash"
			-a = --all 
			
		To view stashes : 
			git stash list 
			
		git switch bugfix/signup-form 
		
		to view stash to current branch : 
			git stash show stash@{1}
				or shorter 
			git stash show 1 
			
		to apply stash to current branch : 
			git stash apply 1 
			
		after applying(doesnt have to be applied to be deleted), delete stash by : 
			git stash drop 1 
			
		git stash list 
		
		to remove all stashes : 
			git stash clear


	7. merging 
	
		merges = briniging changes from another branch 
		
		** There are two type of ways to merge 
		Fast-forward merges = After separing bugfix branch from master branch and changes were made to bugfix. 
			No actual changes were made to master branch so latest source codes are in bugfix. 
		
			There are two ways : Copy all changed files from bugfix to master (merge bugfix to master) 
			OR a better way, since if there are hundreds, thounsands of files that needs to be copied,
			Simply making bugfix branch a master branch aka fast-forward merge 
		
			A linear path from master to bugfix = a fast-forward merge is perfect for this situation 
			Then remove bugfix branch (if branches have not diverged) 
			
		3-way merges = Merge commit (if branches have diverged)
		
		
		
		
	8. fast forward merges 
		
		git log --oneline --all --graph 
		
		git merge bugfix/signup-form 
		
		git branch bugfix/login-form
		git switch bugfix/login-form 
		OR 
		git switch -C bugfix/login-form
			create bugfix branch and switch 
			
		vim toc.txt 
		git add . 
		git commit -m "Updated toc.txt"
		git log --oneline --all --graph 
		
		git switch master 
		
		no fastforward merge 
			git merge --no-ff bugfix/login-form 
		
		cons : 
			- pollutes the history 
			- easier to read as its linear 
			
		pros : 
			- true reflection of history 
			- allow reverting a feature 
			
		how to disable fast-forward merge 
			globally :
				git config --global ff no 
			
			only for current repository : 
				git config ff no 
		
		
	9. three way merges

		git switch -C feature/change-password 
		
		git log --oneline --all --graph 
		
		echo hello > change-password.txt 
		git add . 
		git commit -m "build the change password form "
		
		git log --oneline --all --graph 
		
		git switch master 
		
		vim objectives.txt 
		git add . 
		git commit -m "updated objectives.txt"
		
		git log --oneline --all --graph
		
		git merge feature/change-password
		
		
	10. viewing merged and unmerged 
	
		git branch --merged 
		
		git branch -d bugfix/login-form 
		
		git branch --no-merged 
		
	11. merge conflicts 
	
		conflicts 
		- change1, change2
		- change, delete 
		- add1, add2 
		
		git switch -C bugfix/change-password 
		vim password.txt 
		
		git add. 
		git commit -m "Update change-password.txt"
		
		git switch master 
		vim password.txt 
		
		git add . 
		git commit -m "updated password.txt from master branch "
		
		git merge bugfix/change-password 
		
		git status 
		vim password.txt 
		
		git add password.txt 
		git status 
		git commit 
		
		
	12. graphical merge tools 
	
		merge tools 
			kdiff 
			p4merge
			winmerge
			
		ide 
			gitkraken 
			intellij
			
		git config --global merge.tool p4merge 
		git config --global mergetool.p4merge.path "C:\Program Files\P4merge\ADD FULL PATH"
		
		
	
	13. aborting a merge
	
		git merge --abort 
		
	14. undoing a faulty merge 
	
		remove a commit : it is rewriting history, rewriting history is fine as long as it'same
			done locally 
		or 
		
		revert a commit 
		
		remove a commit : 
			git reset --hard HEAD~1 
			
			resetting 
				soft - only effect last snapshot 
				mixed - effect snapshot + staging area 
				hard - effect snapshot + staging area + working dir 
			
			if you want to go back to the merged commit : 
				git reset --hard 2884030
				
				**but unique id must be written down since it does not show upon --all option 
		
		revert a commit : 
			git revert -m 1 HEAD 
			
			BEFORE : 
			*   2884030 (HEAD -> master) Merge branch 'bugfix/change-password'
			|\
			| * eefbff4 (bugfix/change-password) updated password.txt
			* | 8448e22 updated password.txt master branch
			|/
			*   0d064a4 Merge branch 'feature/change-password'
			|\
			| * 2b50e08 (feature/change-password) password feature added
			* | 1fa4ee1 updated objectives
			|/
			*   5d83c5b (list) Merge branch 'bugfix/login-form'
			|\
			| * 3a21621 Updated toc.txt
			|/
			* 5a2b2ac (bugfix/signup-form) FIX THE BUGGGGG
			* fbff4c6 Restored toc.txt
			* 3b32e73 REMOVED toct.txtttt

			AFTER : 
			* 19ac19c (HEAD -> master) Revert "Merge branch 'bugfix/change-password'"
			*   2884030 Merge branch 'bugfix/change-password'
			|\
			| * eefbff4 (bugfix/change-password) updated password.txt
			* | 8448e22 updated password.txt master branch
			|/
			*   0d064a4 Merge branch 'feature/change-password'
			|\
			| * 2b50e08 (feature/change-password) password feature added
			* | 1fa4ee1 updated objectives
			|/
			*   5d83c5b (list) Merge branch 'bugfix/login-form'
			|\
			| * 3a21621 Updated toc.txt
			|/
			* 5a2b2ac (bugfix/signup-form) FIX THE BUGGGGG
			* fbff4c6 Restored toc.txt
			* 3b32e73 REMOVED toct.txtttt

	15. squash merging 
		
		Used when bugfix branch is not a clean commit therefore just add commit to master branch of 
		bugfix branch and then removing bugfix branch for a linear commit history 
		
		ex. 
		1.		master branch 
				|
			   \|/
		0 - 0 - 0 
			\
			 b1 - b2 
				  /|\
				   |
				   bugfix branch 
				   
		2. 		master branch 
						 |
						\|/
		0 - 0 - 0 - (b1 + b2)
			\
			 b1 - b2 
				  /|\
				   |
				   bugfix branch

		3.          master branch 
						 |
						\|/
		0 - 0 - 0 - (b1 + b2)

		for a linear line of commit history 
		
		*This technique "sqush merging" should only be used for short commit history branch with bad history records
		
		git switch -C bugfix/photo-upload 
		echo bugfix >> audience.txt 
		git commit -am "update audience.txt"
		
		echo bugfix >> toc.txt
		git commit -am "update toc.txt"
		
		git log --oneline --all --graph 
		
		Since there are no changes to master branch, fast forward merge is possible but we area assuming
		there are changes to master branch as well. (diverged branches)
		
		git switch master 
		git merge --squash bugfix/photo-upload
		git status -s 
		git commit -m "Fix the bug on the photo upload page."
		git log --oneline --all --graph 
		
		after finishing squash merging, make sure to delete the branch since it may cause 
		confusion in the futre as 
		
		git branch --merged : does not show bugfix/photo-upload 
		
		-d does not delete because git does not see squash merge as merged branch 
		so use -D
		git branch -d bugfix/photo-upload
		git branch -D bugfix/photo-upload
		
		
	16. rebasing 
	
		rebasing rewrites history 
		so rebasing SHOULD ONLY BE USED ******** FOR LOCALLY 
		
		git switch -C feature/shopping-cart 
		echo hello > cart.txt
		git commit -am "add card.txt"
		git add -A & git commit -am "add cart.txt"
		
		git log --oneline --all --graph -7
		git switch master 
		echo hello >> toc.txt 
		git commit -am "update toc.txt"
		git log --oneline --all --graph -7 
			* aecce2c (HEAD -> master) udate toc.txt
			| * 21988d3 (feature/shopping-cart) add cart.txt
			|/
			* a427a2e fix the bug on the photo upload page
			* 19ac19c Revert "Merge branch 'bugfix/change-password'"
			*   2884030 Merge branch 'bugfix/change-password'
			|\
			| * eefbff4 (bugfix/change-password) updated password.txt
			* | 8448e22 updated password.txt master branch
			|/


		git switch feature/shopping-cart 
		git rebase master 
		git log --oneline --all --graph -7 
			* 535a398 (HEAD -> feature/shopping-cart) add cart.txt
			* aecce2c (master) udate toc.txt
			* a427a2e fix the bug on the photo upload page
			* 19ac19c Revert "Merge branch 'bugfix/change-password'"
			*   2884030 Merge branch 'bugfix/change-password'
			|\
			| * eefbff4 (bugfix/change-password) updated password.txt
			* | 8448e22 updated password.txt master branch
			|/

				
		git switch master 
		git merge feature/shopping-cart 
		git log --oneline --all --graph -7 
		
			* 535a398 (HEAD -> master, feature/shopping-cart) add cart.txt
			* aecce2c udate toc.txt
			* a427a2e fix the bug on the photo upload page
			* 19ac19c Revert "Merge branch 'bugfix/change-password'"
			*   2884030 Merge branch 'bugfix/change-password'
			|\
			| * eefbff4 (bugfix/change-password) updated password.txt
			* | 8448e22 updated password.txt master branch
			|/


		echo ocean > toc.txt 
		git commit -am "update toc.txt"
		git switch feature/shopping-cart 
		echo mountain > toc.txt 
		git commit -am "write mountain to toc.txt"
		git switch feature/shopping-cart 
		git rebase master 
		git mergetool 
		 or 
		code toc.txt 
		
		three additional options for rebasing : 
			git rebase --continue 
			git rebase --skip 
			git rebase --abort 
		
		to get rid of untracked files 
			git clean -fd 
		
		when merge, if it is aborted, it leaves a backup file. to disable it : 
			git config --global mergetool.keepBackup false 
		
		
	17. cherry picking 
	
		cherry picking : picking one particular commit and applying it 
		
		* 570c983 (HEAD -> feature/shopping-cart) write mountain to toc.txt
		| * c7901b4 (master) update toc.txt
		|/
		* 535a398 add cart.txt
		* aecce2c udate toc.txt
		* a427a2e fix the bug on the photo upload page
		* 19ac19c Revert "Merge branch 'bugfix/change-password'"
		*   2884030 Merge branch 'bugfix/change-password'
		|\
		
		want to cherry pick HEAD to master 
		
		git switch master 
		git cherry-pick 570c983
		code toc.txt 
		git commit -a 
		git log --oneline --all --graph -7 
		
			* 6903d06 (HEAD -> master) write mountain to toc.txt
			* c7901b4 update toc.txt
			| * 570c983 (feature/shopping-cart) write mountain to toc.txt
			|/
			* 535a398 add cart.txt
			* aecce2c udate toc.txt
			* a427a2e fix the bug on the photo upload page
			* 19ac19c Revert "Merge branch 'bugfix/change-password'"

	
	18. picking a file from another branch 
	
		git switch -C feature/send-email 
		echo river > toc.txt 
		git commit -am "update toc.txt"
		git switch master 
		git restore --source=feature/send-email -- toc.txt 
		
	19. branching in vscode 
		
		download gitlens 
		
	20. branching in gitkraken 
	
05 Collaboration (70m) ===========================================================

	1. introduction 
		
		- collaboration workflows
		- pushing, fetching and pulling 
		- pull requests, issues and milestones 
		- contributing to open-source projects 
		
	2. workflows
		
		centralized vs distributed 
		
		centralized - single repository 
		distributed - every dev has a repository, not dependent on a single respository
		
		centralized workflow - while every dev has a repository, a single repository is made
			to syncronize workflows between all developers. 
			
			private server, cloud server (github, bitbucket)
			
			1. clone from centralized repository 
			2. john makes changes and push to centralized repository 
			3. amy pulls from centralized repository 
			
			integration-manager = only maintainers have push authorization, 
				open-source projects are maintained this way. 
			
			1. fork repository to cloud server 
			2. pull from fork repository 
			3. make changes and push to fork repository 
			4. then ask for pull request to maintainer 
			5. maintainer pull from fork repository, which has made change from contributor 
			6. if everything is ok, merge to maintainer's local repository 
			7. then push to official repository 
			
			
	3. creating a github repository 
	
		
	4. adding collaborators 
	5. cloning a repository 
	
		cd /c/Projects
		git clone https://github.com/Tonyzorz/Mars-.git
		git clone https://github.com/Tonyzorz/Mars-.git MarsProject
		
		cd MarsProject
		
		origin/master and origin/HEAD is a branch that keeps track of master and HEAD branches 
		if you try switching to origin branch, error will be expected 
		and git branch will only list master branch 
		remote tracking branch = origin/master origin/head
		
		git remote 
		
		
	6. fetching 
	
		get all branches from remote repositroy 
			git fetch origin 
			
		get from certain branch from remote repository 
			get fetch origin branch-name 
		
		shows how local and remote branches are diverging 
			git branch -vv 	
		
		git merge origin/master 
		
	7. pulling 
	
		fetch + merge = pull 
		
		echo hello > file1.txt 
		git add . 
		git commit -m "add file1.txt"
		git pull 
		git log --oneline --all --graph -7
			
			*   7b245f4 (HEAD -> main) Merge branch 'main' of https://github.com/Tonyzorz/Mars- into main
			|\
			| * dfde36a (origin/main, origin/HEAD) Update README.md
			* | 6c26775 add file
			|/
			* 9a4b444 Update README.md
			* ee2cbe4 Initial commit

		git reset --hard HEAD~1 
		git log --oneline --all --graph -7
		
			* 6c26775 (HEAD -> main) add file
			| * dfde36a (origin/main, origin/HEAD) Update README.md
			|/
			* 9a4b444 Update README.md
			* ee2cbe4 Initial commit

		git pull --rebase 
		
			* 736c15d (HEAD -> main) add file
			* dfde36a (origin/main, origin/HEAD) Update README.md
			* 9a4b444 Update README.md
			* ee2cbe4 Initial commit

	8. pushing 

		
		git push origin main 
		
		sometimes a push may get rejected because other people work has been commited and 
		local repository is not sync 
		
		** DONT use git push -f as it will OVERWRITE other people's work 
		
		
	9. storing credentials 
	
		git config --global credential.helper cache 
		
		git-credential-manager-for-windows 
		
	10. sharing tags 
	
		git tag v1.0 
		$ git log --oneline --all --graph
		* 736c15d (HEAD -> main, tag: v1.0, origin/main, origin/HEAD) add file
		* dfde36a Update README.md
		* 9a4b444 Update README.md
		* ee2cbe4 Initial commit

		git push origin v1.0 
		Why use tag? github allows you to download tag version of project by zip 
		
		delete from remote 
			git push origin --delete v1.0 
		delete from local 
			git tag -d v1.0 
		
	11. releases 
	12. sharing branches 
	
		git switch -C feature/change-password 
		git push 
		git branch -vv 
		git branch -r 
		git push -u origin feature/change-password 
		
		git push -d origin feature/change-password 
		git branch -r 
		git branch -vv 
		git branch 
		git switch master 
		git branch -d feature/change-password 
		
		
	13. collaboration workflows 
	
		git fetch 
		git branch 
		git branch -r 
		git switch -C feature/change-password origin/feature/change-password 
		
		
		
	14. pull requests 
	15. resolving conflicts 
	16. issues 
	17. labels 
	18. milestones 
	19. contributing to open source projects 
	20. keeping a forked repository up to date 
	21. collaboration using vscode 
	22. collaboration using gitkraken 
	
	
06 Rewriting History (56m) =======================================================
	
	1. introduction
	2. why rewrite history 
	3. the golden rule of rewriting history 
	4. example of a bad history 
	5. undoing commits 
	6. reverting commits 
	7. recovering lost commits 
	8. amending the last commit 
	9. amending an earlier commit 
	10. dropping commits 
	11. rewording commmit messages 
	12. reordering commits 
	13. squashing commits 
	14. splitting a commit 
	15. rewriting history using gitkraken 
	16. course wrap up 
	
	
	


