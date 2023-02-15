import org.owasp.dependencycheck.reporting.ReportGenerator

plugins {
    id("org.owasp.dependencycheck")
}

configure<org.owasp.dependencycheck.gradle.extension.DependencyCheckExtension> {
    analyzers.nodeAuditEnabled = false
    analyzers.nodeEnabled = false
    analyzers.assemblyEnabled = false
    failBuildOnCVSS = 9.0F
    suppressionFile = "suppressions.xml"
    format = ReportGenerator.Format.valueOf(project.properties["dependencyCheckFormat"] as String? ?: "HTML").toString()
}
