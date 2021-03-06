package sbt.tox4j.lint

import de.johoop.findbugs4sbt.FindBugs._
import de.johoop.findbugs4sbt._
import sbt.tox4j.OptionalPlugin

// scalastyle:off
object Findbugs extends OptionalPlugin {

  object Keys

  override val moduleSettings = findbugsSettings ++ Seq(
    findbugsReportType := Some(ReportType.Html),
    findbugsExcludeFilters := Some(
      <FindBugsFilter>
        <Match>
          <Package name="im.tox.tox4j.av.proto.Av"/>
        </Match>
        <Match>
          <Package name="im.tox.tox4j.core.proto.Core"/>
        </Match>
      </FindBugsFilter>
    )
  )

}
