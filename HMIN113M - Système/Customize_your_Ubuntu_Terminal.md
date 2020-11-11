Customize your Ubuntu Terminal:
------------------------------

1. Install ***ZSH*** Terminal:
    - Verify if you are already installed ZSH:\
        `zsh --version`

    - If it's not installed! run the command below:\
        `sudo apt-get update && sudo apt-get upgrade -y && sudo apt-get install zsh`

2. Make ZSH your default Terminal:   
    - If you have root access:\
        `chsh -s /usr/local/bin/zsh` \
    or\
        `chsh -s $(which zsh)`          # chsh stands for '**ch**ange **sh**ell'

    - If you have **NOT** root access:
        - Create `.bash_profile` in your home directory and add these lines:\
            `export SHELL=/bin/zsh`
            `exec /bin/zsh -l`

3. Check if ZSH is your default Terminal:   
    - `echo $0`\
    or
    - `echo $SHELL`

4. Install ***Oh-My-ZSH***:
    - `sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"`

5. Install **Powerline Fonts** because many themes require installing the Powerline Fonts in order to render properly.
    - `sudo apt-get install fonts-powerline`

6. You can add your favorite **plugins** into the file "~/.zshrc". My favorite plugins list is:
    - `plugins=(git python vscode httpie urltools 
      web-search command-not-found Colored-man-pages 
      zsh-syntax-highlighting zsh-autosuggestions)`

7. If you are interested in **zsh-syntax-highlighting** and **zsh-autosuggestions** plugins, you can install them by following commands:
    - `git clone https://github.com/zsh-users/zsh-autosuggestions ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-autosuggestions`
    - `git clone https://github.com/zsh-users/zsh-syntax-highlighting.git ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-syntax-highlighting`


8. You can change the default **Theme** in the `~/.zshrc`:
    - `ZSH_THEME="robbyrussell"`

9. There is a lot of themes in the below folder:
    - `~/.oh-my-zsh/themes`

10. You can let the computer select one **randomly** for you each time you open a new terminal window:
    - `ZSH_THEME="random"`


Resources:    
    - https://ohmyz.sh/   
    - https://github.com/ohmyzsh/ohmyzsh/wiki/Installing-ZSH   
    - https://github.com/ohmyzsh/ohmyzsh   
    - https://github.com/ohmyzsh/ohmyzsh/wiki/Themes   
    - https://github.com/ohmyzsh/ohmyzsh/tree/master/plugins   
    - https://github.com/zsh-users/zsh-syntax-highlighting   
    - https://github.com/zsh-users/zsh-autosuggestions   
    - https://github.com/ohmyzsh/ohmyzsh/wiki/Customization   
    - http://www.nparikh.org/unix/prompt.php#zsh   
