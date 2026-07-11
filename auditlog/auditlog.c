#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>

#define LOG_FILE "audit.log"

void add_log(char *message)
{
    int fd = open(LOG_FILE, O_WRONLY | O_CREAT | O_APPEND, 0644);

    if (fd < 0)
        return;

    write(fd, message, strlen(message));
    write(fd, "\n", 1);

    close(fd);
}

void view_log()
{
    int fd = open(LOG_FILE, O_RDONLY);

    if (fd < 0)
        return;

    char buffer[1024];
    char line[1024];
    int bytes;
    int index = 0;
    int line_no = 1;

    while ((bytes = read(fd, buffer, sizeof(buffer))) > 0)
    {
        for (int i = 0; i < bytes; i++)
        {
            if (buffer[i] == '\n')
            {
                line[index] = '\0';

                char output[1200];
                int len = sprintf(output, "%d: %s\n", line_no, line);

                write(STDOUT_FILENO, output, len);

                line_no++;
                index = 0;
            }
            else
            {
                line[index++] = buffer[i];
            }
        }
    }

    close(fd);
}

int main(int argc, char *argv[])
{
    if (argc < 2)
        return 1;

    if (strcmp(argv[1], "--add") == 0 && argc == 3)
    {
        add_log(argv[2]);
    }
    else if (strcmp(argv[1], "--view") == 0)
    {
        view_log();
    }

    return 0;
}
