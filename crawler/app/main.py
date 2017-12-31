# coding: UTF-8

import json
import webapp2

from google.appengine.api import taskqueue
from logging import getLogger


def logger():
    return getLogger(__name__)


class HelloWorld(webapp2.RequestHandler):
    def get(self):
        """get

        Router handler.
        Just rendering hello world on json.
        """

        logger().info("query param q : %s", self.request.get("q"))
        self.response.headers["Content-Type"] = "application/json"
        resp = {"message": "Hello World!!"}
        self.response.write(json.dumps(resp))


class Cron(webapp2.RequestHandler):
    def get(self):
        """cron job handler

        Call by cron job.
        """

        logger().info("start crawl...")
        # Taskqueueにタスクを追加する
        task = taskqueue.add(
            queue_name="sample-queue",
            url="/admin/task",
            params={"foo": "bar"},
        )
        logger().info("Task %s encueued, ETA %s", task.name, task.eta)


class Task(webapp2.RequestHandler):
    def post(self):
        """post

        Handler called by taskqueue.
        Should be write crawl process in this handler?
        """

        logger().info("call task with foo param %s", self.request.get("foo"))
        # サイトスクレイピングして、リンクがあればTaskqueueに突っ込んで再帰的に処理してくとか


app = webapp2.WSGIApplication([
    ('/', HelloWorld),
    ('/admin/cron', Cron),
    ('/admin/task', Task),
], debug=True)
